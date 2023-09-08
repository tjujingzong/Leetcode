/*
 * @lc app=leetcode.cn id=799 lang=java
 *
 * [799] Champagne Tower
 */

// @lc code=start
class Solution {
  public double champagneTower(int poured, int query_row, int query_glass) {
    // 动态规划
    double[][] dp = new double[101][101];
    dp[0][0] = poured;
    for (int i = 1; i <= query_row; i++) {
      for (int j = 0; j <= i; j++) {
        if (dp[i - 1][j] > 1) {
          dp[i][j] += (dp[i - 1][j] - 1) / 2;
          dp[i][j + 1] += (dp[i - 1][j] - 1) / 2;
        }
      }
    }
    return dp[query_row][query_glass] > 1 ? 1 : dp[query_row][query_glass];
  }
}
// @lc code=end