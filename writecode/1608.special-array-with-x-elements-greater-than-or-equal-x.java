import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] Special Array With X Elements Greater Than or Equal X
 */

// @lc code=start
class Solution {
  public int specialArray(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 1; i < n; i++) {
      if (nums[n - 1 - i] < i && nums[n - i] >= i)
        return i;
    }
    if (nums[0] >= n)
      return n;
    return -1;
  }
}
// @lc code=end
