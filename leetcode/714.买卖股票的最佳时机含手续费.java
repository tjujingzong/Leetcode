/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    if (n == 0)
      return 0;
    int[][] dp = new int[n][2];
    // 0表示手上没股票，1表示手上有股票
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return Math.max(dp[n - 1][0], dp[n - 1][1]);
  }
}
// @lc code=end
