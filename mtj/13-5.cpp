#include <bits/stdc++.h>

using namespace std;
int visit[20]; // 判断是否访问过
int grid[20][20];
int ans = 20000;
int n;
void dfs(int pos, int len, int nums)
{
  if (len > ans) //剪枝
    return;
  if (nums == n - 1)
  {
    if (len + grid[pos][1] < ans)
      ans = len + grid[pos][1];
  }
  for (int i = 2; i <= n; i++)
  {
    if (i == pos)
      continue;
    if (visit[i] == 0)
    {
      visit[i] = 1;
      dfs(i, len + grid[pos][i], nums + 1);
      visit[i] = 0;
    }
  }
}
int main()
{
  cin >> n;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      cin >> grid[i][j];
  dfs(1, 0, 0);
  cout << ans << endl;
}