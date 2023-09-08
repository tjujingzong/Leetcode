/*
 * @lc app=leetcode.cn id=1413 lang=java
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
class Solution {
  public int minStartValue(int[] nums) {
    int min = nums[0];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum < min) {
        min = sum;
      }
    }
    return min >= 1 ? 1 : 1 - min;
  }
}
// @lc code=end
