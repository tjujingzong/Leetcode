/*
 * @lc app=leetcode.cn id=2465 lang=java
 *
 * [2465] Number of Distinct Averages
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;

class Solution {
  public int distinctAverages(int[] nums) {
    Arrays.sort(nums);
    HashSet<Double> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n / 2; i++) {
      set.add((nums[i] + nums[n - i - 1]) / 2.0);
    }
    return set.size();
  }
}
// @lc code=end
