import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
  public List<String> stringMatching(String[] words) {
    for (int i = 0; i < words.length-1; i++) {
      for (int j = i + 1; j < words.length ; j++) {
        if (words[j].length() < words[i].length()) {
          String tmp = words[i];
          words[i] = words[j];
          words[j] = tmp;
        }
      }
    }
    ArrayList<String> res = new ArrayList<String>();
    for (int i = 0; i < words.length - 1; i++)
      for (int j = i + 1; j < words.length; j++)
        if (words[j].contains(words[i])) {
          res.add(words[i]);
          break;
        }
    return res;
  }
}
// @lc code=end
