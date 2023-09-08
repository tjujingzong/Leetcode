#include <bits/stdc++.h>
using namespace std;
int father[1005];
int find(int x) {
  if (x != father[x]) {
    father[x] = find(father[x]);  // 路径压缩
  }
  return father[x];
}

void myunion(int x, int y) {
  int fx = find(x), fy = find(y);
  if (fx != fy) {
    father[fx] = fy;
  }
}
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  pair<int, int> roads[m];
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    roads[i] = make_pair(a, b);
  }
  for (int i = 0; i < k; i++) {
    int city;
    cin >> city;
    for (int j = 1; j <= n; j++) {
      father[j] = j;
    }
    for (int j = 0; j < m; j++) {
      if (roads[j].first != city && roads[j].second != city) {
        myunion(roads[j].first, roads[j].second);
      }
    }
    int count = 0;
    for (int j = 1; j <= n; j++) {
      if (father[j] == j) {
        count++;
      }
    }
    cout << count - 2 << endl;
  }
}