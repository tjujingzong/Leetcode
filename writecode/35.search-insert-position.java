/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
  public int searchInsert(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }
    return l;
  }
}
// @lc code=end
