/*
 * @lc app=leetcode.cn id=1163 lang=java
 *
 * [1163] Last Substring in Lexicographical Order
 */

// @lc code=start
class Solution {
  public String lastSubstring(String s) {
      int i = 0, j = 1, n = s.length();
      while (j < n) {
          int k = 0;//比较从i和j开始的字符串，找到最大的那个，然后i和j分别向后移动k+1位
          while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
              k++;
          }
          if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
              int t = i;
              i = j;
              j = Math.max(j + 1, t + k + 1);
          } else {
              j = j + k + 1;
          }
      }
      return s.substring(i);
  }
}
// @lc code=end
