/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    for (int num : nums)
      if (num <= target)
        dp[num] = 1;
    for (int i = 1; i <= target; i++)
      for (int num : nums)
        if (i >= num)
          dp[i] += dp[i - num];
    return dp[target];
  }
}
// @lc code=end
