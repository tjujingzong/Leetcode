class Solution {
  public int countHousePlacements(int n) {
    long[][] dp = new long[n][4];
    dp[0][0] = 1;
    dp[0][1] = 1;
    dp[0][2] = 1;
    dp[0][3] = 1;
    int m = 1000000007;
    for (int i = 1; i < n; i++) {
      dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % m;
      dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % m;
      dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % m;
      dp[i][3] = dp[i - 1][0];
    }
    return (int)(dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3]) % m;
  }
}