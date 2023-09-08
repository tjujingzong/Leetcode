/*
 * @lc app=leetcode.cn id=1255 lang=java
 *
 * [1255] Maximum Score Words Formed by Letters
 */

// @lc code=start
class Solution {
  int ans = 0;

  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] letterCount = new int[26];
    for (char c : letters) {
      letterCount[c - 'a']++;
    }
    dfs(words, letterCount, score, 0, 0);
    return ans;
  }

  private void dfs(String[] words, int[] letterCount, int[] score, int i, int j) {
    if (i == words.length) {
      ans = Math.max(ans, j);
      return;
    }
    int[] temp = new int[26];
    boolean flag = true;
    for (char c : words[i].toCharArray()) {
      temp[c - 'a']++;
      if (temp[c - 'a'] > letterCount[c - 'a']) {
        flag = false;
        break;
      }
    }
    if (flag) {
      for (int k = 0; k < 26; k++) {
        letterCount[k] -= temp[k];
      }
      dfs(words, letterCount, score, i + 1, j + getScore(words[i], score));
      for (int k = 0; k < 26; k++) {
        letterCount[k] += temp[k];
      }
    }
    dfs(words, letterCount, score, i + 1, j);
  }

  private int getScore(String string, int[] score) {
    int res = 0;
    for (char c : string.toCharArray()) {
      res += score[c - 'a'];
    }
    return res;
  }
}
// @lc code=end
