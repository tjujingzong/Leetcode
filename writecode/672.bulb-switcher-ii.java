/*
 * @lc app=leetcode.cn id=672 lang=java
 *
 * [672] Bulb Switcher II
 */

// @lc code=start
class Solution {
  public int flipLights(int n, int presses) {
    if (presses == 0)
      return 1;
    if (n >= 3 && presses >= 3)
      return 8;
    if (n >= 2 && presses == 2)
      return 7;
    if (n == 1)
      return 2;
    if (n == 2 && presses == 1)
      return 3;
    return 4;
  }
}
// @lc code=end
