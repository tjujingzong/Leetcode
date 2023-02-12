/*
 * @lc app=leetcode.cn id=1798 lang=java
 *
 * [1798] Maximum Number of Consecutive Values You Can Make
 */

// @lc code=start
class Solution {
  public int getMaximumConsecutive(int[] coins) {
    Arrays.sort(coins);
    int ans = 0;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] > ans + 1) {
        break;
      }
      ans += coins[i];
    }
    return ans + 1;
  }
}
// @lc code=end
