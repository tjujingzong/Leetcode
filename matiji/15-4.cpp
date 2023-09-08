#include <bits/stdc++.h>

using namespace std;
int dp[2005][2005];
int ans,mid;
int main()
{
  int n;
  cin >> n;
  int c1, c2, c3;
  cin >> c1 >> c2 >> c3;
  int t1, t2, p, q, l, r, x, y;
  for (int i = 0; i < n; ++i)
  {
    cin >> t1 >> t2;
    p = max(t1, p);
    q = max(t2, q);
    x = t1, y = t2;
    while (x != 0)
    {
      l = (c1 * (t1 - x) + c2 * t2 - c3) / c2;
      r = t2 + 1;
      if (l < 0)
        l = 0;
      while (r > l)
      {
        mid = (l + r) / 2;
        if (c1 * (t1 - x) + c2 * (t2 - mid) <= c3)
        {
          y = mid;
          r = mid;
        }
        else
          l = mid + 1;
      }
      if (y <= t2 + 1)
      {
        dp[x][y]++;
        dp[x][t2 + 1]--;
      }
      y = t2 + 1;
      x--;
    }
  }
  for (int i = 0; i <= p; i++)
  {
    int sum = 0;
    for (int j = 0; j < q; j++)
    {
      sum += dp[i][j];
      if (sum > ans)
        ans = sum;
    }
  }
  cout << ans;
  return 0;
}