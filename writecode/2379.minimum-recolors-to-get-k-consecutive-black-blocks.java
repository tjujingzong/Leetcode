/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] Minimum Recolors to Get K Consecutive Black Blocks
 */

// @lc code=start
class Solution {
  public int minimumRecolors(String blocks, int k) {
    int ans = 0;
    for (int i = 0; i < k; i++) {
      if (blocks.charAt(i) == 'W') {
        ans++;
      }
    }
    int min = ans;
    for (int i = k; i < blocks.length(); i++) {
      if (blocks.charAt(i) == 'W') {
        ans++;
      }
      if (blocks.charAt(i - k) == 'W') {
        ans--;
      }
      min = Math.min(min, ans);
    }
    return min;
  }
}
// @lc code=end
