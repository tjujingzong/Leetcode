/*
 * @lc app=leetcode.cn id=2460 lang=java
 *
 * [2460] Apply Operations to an Array
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
  public int[] applyOperations(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[i] = nums[i] * 2;
        nums[i + 1] = 0;
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        list.add(nums[i]);
      }
    }
    for (int i = 0; i < n; i++) {
      if (i < list.size()) {
        nums[i] = list.get(i);
      } else {
        nums[i] = 0;
      }
    }
    return nums;
  }
}
// @lc code=end
