/*
 * @lc app=leetcode.cn id=1247 lang=java
 *
 * [1247] Minimum Swaps to Make Strings Equal
 */

// @lc code=start
class Solution {
  public int minimumSwap(String s1, String s2) {
    int n = s1.length();
    int x = 0;
    int y = 0;
    int diff = 0;
    int diffx = 0;
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) == 'x')
        x++;
      else
        y++;
      if (s2.charAt(i) == 'x')
        x++;
      else
        y++;
      if (s1.charAt(i) != s2.charAt(i)) {
        diff++;
        if (s1.charAt(i) == 'x')
          diffx++;
      }
    }
    if (x % 2 == 1 || y % 2 == 1)
      return -1;
    int diffy = diff - diffx;
    return diffx / 2 + diffy / 2 + diffx % 2 * 2;
  }
}
// @lc code=end
