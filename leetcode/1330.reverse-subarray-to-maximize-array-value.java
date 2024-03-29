/*
 * @lc app=leetcode.cn id=1330 lang=java
 *
 * [1330] Reverse Subarray To Maximize Array Value
 */

// @lc code=start
class Solution {
  public int maxValueAfterReverse(int[] nums) {
    int value = 0, n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      value += Math.abs(nums[i] - nums[i + 1]);
    }
    int mx1 = 0;
    for (int i = 1; i < n - 1; i++) {
      mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
      mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
    }
    int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      int x = nums[i], y = nums[i + 1];
      mx2 = Math.max(mx2, Math.min(x, y));
      mn2 = Math.min(mn2, Math.max(x, y));
    }
    return value + Math.max(mx1, 2 * (mx2 - mn2));
  }
}

// @lc code=end
