/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] Buddy Strings
 */

// @lc code=start
class Solution {
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length())
      return false;
    int[] count = new int[26];
    int diff = 0;
    int first = 0, second = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      if (s.charAt(i) != goal.charAt(i)) {
        diff++;
        if (diff == 1)
          first = i;
        else if (diff == 2)
          second = i;
        else
          return false;
      }
      max = Math.max(max, count[s.charAt(i) - 'a']);
    }
    if (diff == 0 && max >= 2)
      return true;
    if (diff == 2 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first))
      return true;
    return false;

  }
}
// @lc code=end
