/*
 * @lc app=leetcode.cn id=831 lang=java
 *
 * [831] Masking Personal Information
 */

// @lc code=start
class Solution {
  public String maskPII(String s) {
    if (s.contains("@")) {
      s = s.toLowerCase();
      String[] ss = s.split("@");
      return ss[0].charAt(0) + "*****" + ss[0].charAt(ss[0].length() - 1) + "@" + ss[1];
    } else {
      s = s.replaceAll("[^0-9]", "");
      String res = "";
      if (s.length() > 10) {
        res = "+" + new String(new char[s.length() - 10]).replace("\0", "*") + "-";
      }
      res += "***-***-" + s.substring(s.length() - 4);
      return res;
    }
  }
}
// @lc code=end
