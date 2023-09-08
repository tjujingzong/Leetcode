
class Solution {
  public int distinctSequences(int n) {
    int[][] dp = new int[n][7];
    int m = 10e9 + 7;
    for (int i = 1; i <= 6; i++)
      dp[0][i] = 1;
    if (n == 1)
      return 6;
    for (int i = 1; i < n; i++) {
      if (i == 1) {
        dp[i][1] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6];
        dp[i][2] = dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5];
        dp[i][3] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5];
        dp[i][4] = dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5];
        dp[i][5] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][6];
        dp[i][6] = dp[i - 1][1] + dp[i - 1][5];
      } else if (i == 2) {
        dp[i][1] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] - dp[i - 2][1] * 5;
        dp[i][2] = dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] - dp[i - 2][2] * 3;
        dp[i][3] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5] - dp[i - 2][3] * 4;
        dp[i][4] = dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] - dp[i - 2][4] * 3;
        dp[i][5] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][6] - dp[i - 2][5] * 5;
        dp[i][6] = dp[i - 1][1] + dp[i - 1][5] - dp[i - 2][6] * 2;
      } else {
        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] - dp[i - 2][1] * 4) % m;
        dp[i][2] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] - dp[i - 2][2] * 2) % m;
        dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5] - dp[i - 2][3] * 3) % m;
        dp[i][4] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] - dp[i - 2][4] * 2) % m;
        dp[i][5] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][6] - dp[i - 2][5] * 4) % m;
        dp[i][6] = (dp[i - 1][1] + dp[i - 1][5] - dp[i - 2][6] * 1) % m;
      }
    }
    long ans = 0;
    for (int i = 1; i <= 6; i++)
      ans += dp[n - 1][i];
    return (int) ans;
  }
}