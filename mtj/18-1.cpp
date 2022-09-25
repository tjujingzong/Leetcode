#include <bits/stdc++.h>

using namespace std;
int n, m, k1, k2;
int ans1, ans2;
struct node
{
  int r, c;
};

int main()
{
  cin >> n >> m >> k1 >> k2;
  node grid[n * m];
  int gap = n * m / 2;
  int p = 0;
  for (int i = 0; i < n; i++)
  {
    if (i % 2 == 0)
    {
      for (int j = 0; j < m; j++)
      {
        grid[p].r = i;
        grid[p].c = j;
        p++;
      }
    }
    else
    {
      for (int j = m - 1; j >= 0; j--)
      {
        grid[p].r = i;
        grid[p].c = j;
        p++;
      }
    }
  }
  for (int i = 0; i < gap; i++)
    ans1 = max(ans1, k1 * abs(grid[i].r - grid[i + gap].r) + k2 * abs(grid[i].c - grid[i + gap].c));
  p=0;
  for (int j = 0; j < m; j++)
  {
    if (j % 2 == 0)
    {
      for (int i = 0; i < n; i++)
      {
        grid[p].r = i;
        grid[p].c = j;
        p++;
      }
    }
    else
    {
      for (int i = n - 1; i >= 0; i--)
      {
        grid[p].r = i;
        grid[p].c = j;
        p++;
      }
    }
  }
  for (int i = 0; i < gap; i++)
    ans2 = max(ans2, k1 * abs(grid[i].r - grid[i + gap].r) + k2 * abs(grid[i].c - grid[i + gap].c));
  cout << min(ans1, ans2);
  return 0;
}