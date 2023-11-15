#include <bits/stdc++.h>

using namespace std;
int dis[10][10];
int n;
bool vis[10];
int mindis = 0x3f3f3f3f;
void dfs(int nowpos, int step, int sum) {
  if (step == n && nowpos == 1) {
    mindis = min(mindis, sum);
    return;
  }
  for (int i = 1; i <= n; i++) {
    if (step != n - 1 && i == 1)
      continue;
    if (i == nowpos)
      continue;
    if (!vis[i]) {
      vis[i] = true;
      dfs(i, step + 1, sum + dis[nowpos][i]);
      vis[i] = false;
    }
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++)
      cin >> dis[i][j];
  }
  dfs(1, 0, 0);
  if (n == 1)
    cout << 0;
  else
    cout << mindis;
  return 0;
}