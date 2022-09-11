import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
  public String minWindow(String s, String t) {
    String ans = "";
    if (s.length() < t.length())
      return ans;
    HashMap<Character, Integer> mapt = new HashMap<Character, Integer>();
    HashMap<Character, Integer> maps = new HashMap<Character, Integer>();
    for (int i = 0; i < t.length(); i++)
      mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
    int i = 0, j = 0;
    int length = s.length()+1;
    int cnt = 0;
    while (j < s.length()) {
      Character c = s.charAt(j);
      maps.put(s.charAt(j), maps.getOrDefault(s.charAt(j), 0) + 1);
      if (mapt.containsKey(c) && maps.get(c) <= mapt.get(c))
        cnt++;
      while (i < j && (!mapt.containsKey(s.charAt(i)) || maps.get(s.charAt(i)) > mapt.get(s.charAt(i)))) {
        maps.put(s.charAt(i), maps.get(s.charAt(i)) - 1);
        i++;
      }
      if (cnt == t.length() && j - i + 1 < length && i <= j) {
        length = j - i + 1;
        ans = s.substring(i, j + 1);
      }
      j++;
    }
    return ans;
  }
}
// @lc code=end
