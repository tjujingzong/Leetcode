/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] Number of Times Binary String Is Prefix-Aligned
 */

// @lc code=start
class Solution {
  public int numTimesAllBlue(int[] flips) {
    int max = 0, res = 0;
    for (int i = 0; i < flips.length; i++) {
      max = Math.max(max, flips[i]);
      if (max == i + 1) {
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
