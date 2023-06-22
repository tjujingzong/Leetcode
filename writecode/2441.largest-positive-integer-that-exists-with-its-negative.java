/*
 * @lc app=leetcode.cn id=2441 lang=java
 *
 * [2441] Largest Positive Integer That Exists With Its Negative
 */

// @lc code=start
class Solution {
  public int findMaxK(int[] nums) {
    boolean[][] cnt = new boolean[1005][2];
    for (int x : nums) {
      if (x >= 0)
        cnt[x][0] = true;
      else
        cnt[-x][1] = true;
    }
    for (int i = 1000; i >= 0; i--) {
      if (cnt[i][0] && cnt[i][1])
        return i;
    }
    return 0;
  }
}
// @lc code=end
