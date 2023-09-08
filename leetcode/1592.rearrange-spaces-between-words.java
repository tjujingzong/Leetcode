import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] Rearrange Spaces Between Words
 */

// @lc code=start
class Solution {
  public String reorderSpaces(String text) {
    int spacecnt = 0;
    int i = 0;
    ArrayList<String> words = new ArrayList<String>();
    while (i < text.length()) {
      if (text.charAt(i) == ' ') {
        spacecnt++;
        i++;
      } else {
        int j = i;
        while (j < text.length() && text.charAt(j) != ' ') {
          j++;
        }
        words.add(text.substring(i, j));
        i = j;
      }
    }
    int wordscnt = words.size();
    int spacegap = wordscnt == 1 ? 0 : spacecnt / (wordscnt - 1);
    int lastspace = wordscnt == 1 ? spacecnt : spacecnt % (wordscnt - 1);
    StringBuilder midspace = new StringBuilder();
    for (int k = 0; k < spacegap; k++)
      midspace.append(" ");
    StringBuilder laststr = new StringBuilder();
    for (int k = 0; k < lastspace; k++)
      laststr.append(" ");
    StringBuilder ans = new StringBuilder();
    for (int k = 0; k < words.size() - 1; k++)
      ans.append(words.get(k) + midspace);
    ans.append(words.get(wordscnt - 1) + laststr);
    return ans.toString();
  }
}
// @lc code=end
