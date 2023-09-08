/*
 * @lc app=leetcode.cn id=2299 lang=java
 *
 * [2299] Strong Password Checker II
 */

// @lc code=start
class Solution {
  public boolean strongPasswordCheckerII(String password) {
    if (password.length() < 8)
      return false;
    int upper = 0, lower = 0, digit = 0, special = 0;
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (Character.isUpperCase(c))
        upper = 1;
      else if (Character.isLowerCase(c))
        lower = 1;
      else if (Character.isDigit(c))
        digit = 1;
      else if ("!@#$%^&*()-+".contains(c + ""))
        special = 1;
      char next = i + 1 < password.length() ? password.charAt(i + 1) : ' ';
      if (c == next)
        return false;
    }
    return upper + lower + digit + special > 3;
  }
}
// @lc code=end
