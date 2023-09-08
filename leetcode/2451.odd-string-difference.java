/*
 * @lc app=leetcode.cn id=2451 lang=java
 *
 * [2451] Odd String Difference
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public String oddString(String[] words) {
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String t = "";
      for (int j = 1; j < words[i].length(); j++) {
        t += words[i].charAt(j) - words[i].charAt(j - 1);
        t += '.';
      }
      map.put(t, map.getOrDefault(t, 0) + 1);
      if (map.get(t) == 1) {
        map2.put(t, i);
      }
      if (map.get(t) >= 2) {
        map2.remove(t);
      }
    }

    for (String s : map2.keySet()) {
      return words[map2.get(s)];
    }
    return "";
  }
}
// @lc code=end
