/*
 * @lc app=leetcode.cn id=1813 lang=java
 *
 * [1813] Sentence Similarity III
 */

// @lc code=start
class Solution {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    if (sentence1.length() < sentence2.length()) {
      String temp = sentence1;
      sentence1 = sentence2;
      sentence2 = temp;
    }
    String[] s1 = sentence1.split(" ");
    String[] s2 = sentence2.split(" ");
    boolean[] flag = new boolean[s2.length];

    for (int i = 0; i < s2.length; i++) {
      if (s1[i].equals(s2[i])) {
        flag[i] = true;
      } else
        break;
    }
    for (int i = 0; i < s2.length; i++) {
      if (s1[s1.length - 1 - i].equals(s2[s2.length - 1 - i])) {
        flag[s2.length - 1 - i] = true;
      } else
        break;
    }
    for (int i = 0; i < s2.length; i++) {
      if (!flag[i])
        return false;
    }
    return true;
  }
}
// @lc code=end
