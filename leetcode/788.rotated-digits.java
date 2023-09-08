import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] Rotated Digits
 */

// @lc code=start
class Solution {
  static int[] check = { 0, 0, 1, -1, -1, 1, 1, -1, 0, 1 };

  public int rotatedDigits(int n) {
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
      String num = String.valueOf(i);
      boolean valid = true, diff = false;
      for (int j = 0; j < num.length(); ++j) {
        char ch = num.charAt(j);
        if (check[ch - '0'] == -1) {
          valid = false;
        } else if (check[ch - '0'] == 1) {
          diff = true;
        }
      }
      if (valid && diff) {
        ++ans;
      }
    }
    return ans;
  }
}
// @lc code=end
