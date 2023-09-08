/*
 * @lc app=leetcode.cn id=1704 lang=java
 *
 * [1704] Determine if String Halves Are Alike
 */

// @lc code=start
class Solution {
  public boolean halvesAreAlike(String s) {
    String ss = "aeiouAEIOU";
    int cnt = 0;
    for (int i = 0; i < s.length() / 2; i++)
      if (ss.contains(s.substring(i, i + 1)))
        cnt++;
    for (int i = s.length() / 2; i < s.length(); i++)
      if (ss.contains(s.substring(i, i + 1)))
        cnt--;
    return cnt == 0;
  }
}
// @lc code=end
