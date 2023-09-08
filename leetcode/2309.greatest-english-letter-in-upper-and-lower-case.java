
/*
 * @lc app=leetcode.cn id=2309 lang=java
 *
 * [2309] Greatest English Letter in Upper and Lower Case
 */

// @lc code=start
class Solution {
  public String greatestLetter(String s) {
    String ans = "";
    boolean[] upper = new boolean[26];
    boolean[] lower = new boolean[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        upper[c - 'A'] = true;
      } else {
        lower[c - 'a'] = true;
      }
    }
    for (int i = 25; i >= 0; i--) {
      if (upper[i] && lower[i]) {
        ans += (char) (i + 'A');
        break;
      }
    }
    return ans;
  }
}
// @lc code=end
