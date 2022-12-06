/*
 * @lc app=leetcode.cn id=808 lang=java
 *
 * [808] Soup Servings
 */

// @lc code=start
class Solution {
  public double soupServings(int n) {
    n = (int) Math.ceil((double) n / 25);
    if (n >= 179) {
      return 1.0;
    }
    double[][] dp = new double[n + 1][n + 1];
    dp[0][0] = 0.5;
    for (int i = 1; i <= n; i++) {
      dp[0][i] = 1.0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)]
            + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
      }
    }
    return dp[n][n];
  }
}
// @lc code=end
