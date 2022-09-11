import java.util.Collections;

/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] Replace Words
 */

// @lc code=start
class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {
    Collections.sort(dictionary, (o1, o2) -> o1.length() - o2.length());
    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      for (String prefix : dictionary) {
        if (words[i].startsWith(prefix)) {
          words[i] = prefix;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(word + " ");
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }
}
// @lc code=end
