#include <bits/stdc++.h>

using namespace std;
int arr[105][105];
int ans[105][105];
bool vis[105][105];
int n, m;
int dfs(int x, int y) {
  if (vis[x][y])
    return ans[x][y];
  vis[x][y] = true;
  int res = 1;
  if (x > 0 && arr[x][y] > arr[x - 1][y])
    res = max(res, dfs(x - 1, y) + 1);
  if (x < n - 1 && arr[x][y] > arr[x + 1][y])
    res = max(res, dfs(x + 1, y) + 1);
  if (y > 0 && arr[x][y] > arr[x][y - 1])
    res = max(res, dfs(x, y - 1) + 1);
  if (y < m - 1 && arr[x][y] > arr[x][y + 1])
    res = max(res, dfs(x, y + 1) + 1);
  ans[x][y] = res;
  return res;
}

int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> arr[i][j];
    }
  }
  memset(ans, 0, sizeof(ans));
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (vis[i][j])
        continue;
      ans[i][j] = dfs(i, j);
    }
  }
  int maxn = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      maxn = max(maxn, ans[i][j]);
      cout << ans[i][j] << " ";
    }
    cout << endl;
  }

  cout << maxn << endl;
  return 0;
}