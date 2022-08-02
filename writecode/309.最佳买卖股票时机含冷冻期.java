/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0)
      return 0;
    int[][] dp = new int[n][3];
    /*
     * 0表示持有股票，1表示卖完在冷冻期，2表示卖完不在冷冻期。
     */
    dp[0][0] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
    }
    return Math.max(dp[n - 1][1], dp[n - 1][2]);
  }
}
// @lc code=end
