/*
 * @lc app=leetcode.cn id=1599 lang=java
 *
 * [1599] Maximum Profit of Operating a Centennial Wheel
 */

// @lc code=start
class Solution {
  public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    int n = customers.length;
    int ans = 0;
    int max = 0;
    int maxIndex = -1;
    int cur = 0;
    int i = 0;
    while (i < n || cur > 0) {
      if (i < n)
        cur += customers[i];
      int take = Math.min(cur, 4);
      cur -= take;
      int profit = take * boardingCost - runningCost;
      ans += profit;
      if (ans > max) {
        max = ans;
        maxIndex = i + 1;
      }
      i++;
    }
    return maxIndex;
  }
}
// @lc code=end
