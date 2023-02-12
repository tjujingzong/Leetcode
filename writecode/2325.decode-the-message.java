import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2325 lang=java
 *
 * [2325] Decode the Message
 */

// @lc code=start
class Solution {
  public String decodeMessage(String key, String message) {
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < key.length(); i++) {
      if (key.charAt(i) == ' ') {
        continue;
      }
      if (!map.containsKey(key.charAt(i)))
        map.put(key.charAt(i), (char) ('a' + map.size()));
    }
    map.put(' ', ' ');
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < message.length(); i++) {
      sb.append(map.get(message.charAt(i)));
    }
    return sb.toString();
  }
}
// @lc code=end
