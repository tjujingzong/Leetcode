#include <bits/stdc++.h>

using namespace std;
int main() {
  int n, m, mod;
  cin >> n >> m >> mod;
  vector<vector<int>> a(n + 1, vector<int>(m + 1));
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
      cin >> a[i][j];
  int dp[n + 2][m + 2][mod + 2];
  memset(dp, -0x3f3f3f3f, sizeof(dp));
  dp[0][0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      if (j == 1) {
        for (int k = 0; k <= m / 2; k++)
          for (int l = 0; l < mod; l++)
            dp[i][0][l] = max(dp[i][0][l], dp[i - 1][k][l]);
      }
      // 前面两层循环目的是遍历aij，下面这个就是看aij进去之前已经取了多少个
      for (int k = m / 2 - 1; k >= 0; k--)
        for (int l = 0; l < mod; l++)
          dp[i][k + 1][(l + a[i][j]) % mod] =
              max(dp[i][k + 1][(l + a[i][j]) % mod], dp[i][k][l] + a[i][j]);
    }
  int ans = 0;
  for (int j = 0; j <= m / 2; j++)
    ans = max(ans, dp[n][j][0]);
  cout << ans;
  return 0;
}