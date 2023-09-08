import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
  public int longestStrChain(String[] words) {
      Map<String, Integer> cnt = new HashMap<String, Integer>();
      Arrays.sort(words, (a, b) -> a.length() - b.length());
      int res = 0;
      for (String word : words) {
          cnt.put(word, 1);
          for (int i = 0; i < word.length(); i++) {
              String prev = word.substring(0, i) + word.substring(i + 1);// remove the ith char
              if (cnt.containsKey(prev)) {
                  cnt.put(word, Math.max(cnt.get(word), cnt.get(prev) + 1));
              }
          }
          res = Math.max(res, cnt.get(word));
      }
      return res;
  }
}
// @lc code=end

