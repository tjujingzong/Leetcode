/*
 * @lc app=leetcode.cn id=2559 lang=java
 *
 * [2559] Count Vowel Strings in Ranges
 */

// @lc code=start

import java.util.HashSet;

class Solution {
  public int[] vowelStrings(String[] words, int[][] queries) {
    int n = words.length;
    int m = queries.length;
    int[] ans = new int[m];
    int[] cnt = new int[n + 1];
    HashSet<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    for (int i = 0; i < n; i++) {
      if (set.contains(words[i].charAt(0)) &&
          set.contains(words[i].charAt(words[i].length() - 1)))
        cnt[i + 1] = cnt[i] + 1;
      else
        cnt[i + 1] = cnt[i];
    }
    for (int i = 0; i < m; i++) {
      int l = queries[i][0];
      int r = queries[i][1];
      ans[i] = cnt[r + 1] - cnt[l];
    }
    return ans;
  }
}
// @lc code=end
