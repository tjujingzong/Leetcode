/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
  public int myAtoi(String s) {
    s = s.trim();
    if (s.length() == 0)
      return 0;
    if (s.charAt(0) == '-') {
      s = s.substring(1);
      int p = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0')
          p++;
        else
          break;
      }
      s = s.substring(p);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
          continue;
        else {
          s = s.substring(0, i);
        }
      }
      if (s.length() == 0)
        return 0;
      if (s.length() > 12)
        return Integer.MIN_VALUE;
      else if (-Long.parseLong(s) <= Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      else
        return -Integer.parseInt(s);
    } else {
      if (s.startsWith("+"))
        s = s.substring(1);
      int p = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0')
          p++;
        else
          break;
      }
      s = s.substring(p);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
          continue;
        else {
          s = s.substring(0, i);
        }
      }
      if (s.length() == 0)
        return 0;
      if (s.length() > 12)
        return Integer.MAX_VALUE;
      else if (Long.parseLong(s) > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      else
        return Integer.parseInt(s);
    }
  }
}
// @lc code=end
