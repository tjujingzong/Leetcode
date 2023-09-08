import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2287 lang=java
 *
 * [2287] Rearrange Characters to Make Target String
 */

// @lc code=start
class Solution {
  public int rearrangeCharacters(String s, String target) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (char c : target.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0) + 1);
    }
    int ans = Integer.MAX_VALUE;
    for (char c : map2.keySet()) {
      if (map.containsKey(c)) {
        ans = Math.min(ans, map.get(c) / map2.get(c));
      } else
        return 0;
    }
    return ans;
  }
}
// @lc code=end
