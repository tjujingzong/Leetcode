/*
 * @lc app=leetcode.cn id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
  public boolean isIdealPermutation(int[] nums) {
    // 局部倒置一定是全局倒置，看nums[j]<nums[i]且j-i>1是否成立
    int n = nums.length;
    int max = nums[0];
    for (int i = 2; i < n; i++) {
      if (max > nums[i])
        return false;
      max = Math.max(max, nums[i - 1]);
    }
    return true;
  }
}
// @lc code=end
