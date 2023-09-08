#include <bits/stdc++.h>

using namespace std;
int mod = 2333;
int main() {
  int m, n;
  cin >> m >> n;
  vector<vector<int>> v(m, vector<int>(n));
  vector<vector<int>> dp(m, vector<int>(n));
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      cin >> v[i][j];
      dp[i][j] = 0;
    }
  }
  if (v[m - 1][0] != 1)
    dp[m - 1][0] = 1;
  for (int i = m - 2; i >= 0; i--) {
    if (v[i][0] != 1)
      dp[i][0] = dp[i + 1][0];
  }
  for (int i = 1; i < n; i++) {
    if (v[m - 1][i] != 1)
      dp[m - 1][i] = dp[m - 1][i - 1];
  }
  for (int i = m - 2; i >= 0; i--) {
    for (int j = 1; j < n; j++) {
      if (v[i][j] != 1)
        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1]) % mod;
      else
        dp[i][j] = 0;
    }
  }
  cout << dp[0][n - 1] << endl;
  return 0;
}