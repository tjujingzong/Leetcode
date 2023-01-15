import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=2293 lang=java
 *
 * [2293] Min Max Game
 */

// @lc code=start
class Solution {
  public int minMaxGame(int[] nums) {
    while (nums.length > 1) {
      int temp[] = new int[nums.length / 2];
      for (int i = 0; i < temp.length; i++) {
        if (i % 2 == 0)
          temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        else
          temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
      }
      nums = temp;
    }
    return nums[0];
  }
}
// @lc code=end
