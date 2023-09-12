
#include <bits/stdc++.h>
using namespace std;
const int maxn = 1020;
const int inf = 32787;
int n, m, o, p, l;  // 居民点、垃圾桶、路径、最大距离、l=居民点数+垃圾桶数
int T[maxn][maxn];  // 存无向图
int D[maxn];        // 存单个垃圾桶到每一个居民点的最短距离
bool flag[maxn];    // dijkstra辅助标记数组
void Djs(int a) {
  for (int i = 1; i <= l; i++) {
    D[i] = T[a][i];
  }
  flag[a] = true;
  D[a] = 0;
  for (int i = 1; i <= l; i++) {
    int minid = -1, Min = inf;
    for (int j = 1; j <= l; j++) {
      if (!flag[j] && Min > D[j]) {
        Min = D[j];
        minid = j;
      }
    }
    if (minid == -1)
      return;
    flag[minid] = true;
    for (int j = 1; j <= l; j++) {
      if (!flag[j] && D[j] > D[minid] + T[minid][j]) {
        D[j] = D[minid] + T[minid][j];
      }
    }
  }
}
int main(void) {
  cin >> n >> m >> o >> p;
  l = n + m;
  for (int i = 1; i <= l; i++)  // 初始化
  {
    for (int j = 1; j <= l; j++) {
      T[i][j] = inf;
    }
  }
  // 用数组存储居民点和垃圾桶1-n为居民点下标、n+1~l为垃圾桶下标
  // 区分输入是居民点还是垃圾桶
  for (int i = 0; i < o; i++) {
    string s1, s2;
    int a, b, w;
    cin >> s1 >> s2 >> w;
    if (s1[0] == 'G') {
      s1.erase(0, 1);
      a = stoi(s1) + n;
    } else
      a = stoi(s1);
    if (s2[0] == 'G') {
      s2.erase(0, 1);
      b = stoi(s2) + n;
    } else
      b = stoi(s2);

    T[a][b] = T[b][a] = w;
  }
  // id:符合条件的垃圾桶序号  sum:最短距离总和   min_max：所有最短距离中的最小值
  int id = 0, sum = 0, min_min = 0;
  double aver = 0;  // 平均值
  for (int i = n + 1; i <= l; i++) {
    memset(D, 0, sizeof(D));
    memset(flag, 0, sizeof(flag));
    Djs(i);
    int min_1 = inf, max_1 = 0;
    int sum_1 = 0;
    double aver_1 = 0;
    for (int j = 1; j <= n; j++) {
      if (D[j] < min_1)
        min_1 = D[j];  // 找最小值
      if (D[j] > max_1)
        max_1 = D[j];  // 找最大值
      sum_1 += D[j];
      cout << D[j] << " ";
    }
    cout << endl;
    if (max_1 > p)
      continue;  // 最大值若超出题目规定的最大限额
    aver_1 = sum_1 / (n * 1.0);
    if (min_1 > min_min)  // 求最短距离里最长的地方
    {
      min_min = min_1;
      id = i - n;
      aver = aver_1;
    } else if (min_1 == min_min)  // 若相等，再求平均距离最短的地方
    {
      if (aver > aver_1) {
        aver = aver_1;
        id = i - n;
      }
    }
    // 垃圾桶从小到大遍历，故编号就不用再进行比较
  }

  if (id == 0)
    cout << "No Solution" << endl;
  else {
    cout << "G" << id << endl;
    double b = double(min_min);
    printf("%0.1f %0.1f", b, aver);
  }
  return 0;
}