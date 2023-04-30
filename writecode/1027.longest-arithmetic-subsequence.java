/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start
class Solution {
  public int longestArithSeqLength(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][20001];
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int diff = nums[j] - nums[i] + 10000;
        dp[j][diff] = dp[i][diff] + 1;
        max = Math.max(max, dp[j][diff]);
      }
    }
    return max + 1;
  }
}
// @lc code=end
