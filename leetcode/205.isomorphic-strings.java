import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
  public boolean isIsomorphic(String s, String t) {
    int n = s.length();
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(s.charAt(i))) {
        if (map.get(s.charAt(i)) != t.charAt(i))
          return false;
      } else {
        if (map.containsValue(t.charAt(i)))
          return false;
        map.put(s.charAt(i), t.charAt(i));
      }
    }
    return true;
  }
}
// @lc code=end
