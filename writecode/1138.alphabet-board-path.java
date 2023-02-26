/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] Alphabet Board Path
 */

// @lc code=start
class Solution {
  public String alphabetBoardPath(String target) {
    String ans = "";
    int x = 0, y = 0;
    for (char c : target.toCharArray()) {
      int i = (c - 'a') / 5, j = (c - 'a') % 5;
      if (i == 5) {
        while (y > i) {
          ans += "U";
          y--;
        }
        while (x < j) {
          ans += "R";
          x++;
        }
        while (x > j) {
          ans += "L";
          x--;
        }
        while (y < i) {
          ans += "D";
          y++;
        }
      } else {
        while (x < j) {
          ans += "R";
          x++;
        }
        while (x > j) {
          ans += "L";
          x--;
        }
        while (y < i) {
          ans += "D";
          y++;
        }
        while (y > i) {
          ans += "U";
          y--;
        }
      }
      ans += "!";
    }
    return ans;
  }
}
// @lc code=end
