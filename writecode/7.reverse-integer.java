/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
  public int reverse(int x) {
    StringBuilder sb = new StringBuilder(String.valueOf(x));
    if (x >= 0) {
      if (Long.parseLong(sb.reverse().toString()) > Integer.MAX_VALUE)
        return 0;
      else
        return Integer.parseInt(sb.toString());
    } else {
      if (-Long.parseLong(sb.reverse().substring(0, sb.length() - 1).toString()) < Integer.MIN_VALUE)
        return 0;
      else
        return -Integer.parseInt(sb.substring(0, sb.length() - 1).toString());
    }
  }
}
// @lc code=end
