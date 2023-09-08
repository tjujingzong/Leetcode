#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1005;
int father[MAXN];
int rk[MAXN];

int find(int x) {
  if (x != father[x]) {
    father[x] = find(father[x]);  // 路径压缩
  }
  return father[x];
}

void myunion(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  if (fx != fy) {
    if (rk[fx] < rk[fy]) {
      swap(fx, fy);  // 按秩合并，将深度小的树合并到深度大的树上
    }
    father[fy] = fx;
    if (rk[fx] == rk[fy]) {
      rk[fx]++;
    }
  }
}

int main() {
  int n, m, k;
  cin >> n >> m >> k;

  for (int i = 1; i <= n; i++) {
    father[i] = i;
    rk[i] = 0;
  }

  vector<pair<int, int>> roads(m);
  for (int i = 0; i < m; i++) {
    cin >> roads[i].first >> roads[i].second;
  }

  for (int i = 0; i < k; i++) {
    int city;
    cin >> city;
    for (int j = 0; j < m; j++) {
      if (roads[j].first != city && roads[j].second != city) {
        myunion(roads[j].first, roads[j].second);
      }
    }

    int count = 0;
    for (int j = 1; j <= n; j++) {
      if (find(j) == j) {
        count++;
      }
    }
    cout << count - 2 << endl;
  }

  return 0;
}
