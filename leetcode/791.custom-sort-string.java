/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start
class Solution {
  public String customSortString(String order, String s) {
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < order.length(); i++) {
      while (map[order.charAt(i) - 'a'] > 0) {
        sb.append(order.charAt(i));
        map[order.charAt(i) - 'a']--;
      }
    }
    for (int i = 0; i < 26; i++) {
      while (map[i] > 0) {
        sb.append((char) (i + 'a'));
        map[i]--;
      }
    }
    return sb.toString();
  }
}
// @lc code=end
