import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    if (n < 3)
      return 0;
    int[] dp = new int[n];
    for (int i = 2; i < n; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
        dp[i] = dp[i - 1] + 1;
    }
    int ans = 0;
    for (int i : dp)
      ans += i;
    return ans;
  }
}
// @lc code=end
