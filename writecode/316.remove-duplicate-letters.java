import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
  public String removeDuplicateLetters(String s) {
    TreeMap<Character, Integer> t = new TreeMap<Character, Integer>();
    for (Character c : s.toCharArray()) {
      t.put(c, t.getOrDefault(c, 0) + 1);
    }
    int n = t.size();
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      Character now = s.charAt(i);
      if (t.get(now) == 1) {
        ans += now;
        t.remove(now);
        continue;
      }
      if (!t.containsKey(now))
        continue;
      if (ans.length() == n)
        break;
      if (t.firstKey().equals(now)) {
        ans += now;
        t.remove(now);
      }
      t.put(now, t.get(now) - 1);
    }
    return ans;
  }
}
// @lc code=end
