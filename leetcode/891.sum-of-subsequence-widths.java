/*
 * @lc app=leetcode.cn id=891 lang=java
 *
 * [891] Sum of Subsequence Widths
 */

// @lc code=start
class Solution {
  public int sumSubseqWidths(int[] nums) {
    if (nums.length == 1)
      return 0;
    Arrays.sort(nums);
    int mod = 1000000007;
    long[] dp = new long[nums.length];
    dp[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = (dp[i - 1] * 2) % mod;
    }
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = (sum + (nums[i] - nums[nums.length - 1 - i]) * dp[i]) % mod;
    }
    return (int) sum;
  }
}
// @lc code=end
