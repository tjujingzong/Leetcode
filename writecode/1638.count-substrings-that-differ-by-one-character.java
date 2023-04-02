/*
 * @lc app=leetcode.cn id=1638 lang=java
 *
 * [1638] Count Substrings That Differ by One Character
 */

// @lc code=start
class Solution {
  public int countSubstrings(String s, String t) {
    int len = 1;
    int count = 0;
    while (len <= s.length()) {
      for (int i = 0; i <= s.length() - len; i++) {
        for (int j = 0; j <= t.length() - len; j++) {
          if (isDiff(s.substring(i, i + len), t.substring(j, j + len))) {
            count++;
          }
        }
      }
      len++;
    }
    return count;
  }

  private boolean isDiff(String substring, String substring2) {
    int count = 0;
    for (int i = 0; i < substring.length(); i++) {
      if (substring.charAt(i) != substring2.charAt(i)) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    if (count == 1) {
      return true;
    }
    return false;
  }
}
// @lc code=end
