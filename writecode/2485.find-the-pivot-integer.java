/*
 * @lc app=leetcode.cn id=2485 lang=java
 *
 * [2485] Find the Pivot Integer
 */

// @lc code=start
class Solution {
  public int pivotInteger(int n) {
    int ans = -1;
    for (int i = 1; i < n; i++) {
      if ((1 + i) * i / 2 == (i + n) * (n - i + 1) / 2) {
        ans = i;
        break;
      }
    }
    return ans;
  }
}
// @lc code=end
