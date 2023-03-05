/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] Decrease Elements To Make Array Zigzag
 */

// @lc code=start
class Solution {
  public int movesToMakeZigzag(int[] nums) {
    int ans1 = 0, ans2 = 0;
    for (int i = 0; i < nums.length; i += 2) {
      int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
      int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
      int min = Math.min(left, right);
      if (nums[i] >= min) {
        ans1 += nums[i] - min + 1;
      }
    }
    for (int i = 1; i < nums.length; i += 2) {
      int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
      int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
      int min = Math.min(left, right);
      if (nums[i] >= min) {
        ans2 += nums[i] - min + 1;
      }
    }
    return Math.min(ans1, ans2);
  }
}
// @lc code=end
