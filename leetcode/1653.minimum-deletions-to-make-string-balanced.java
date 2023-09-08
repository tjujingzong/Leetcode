/*
 * @lc app=leetcode.cn id=1653 lang=java
 *
 * [1653] Minimum Deletions to Make String Balanced
 */

// @lc code=start
class Solution {
  public int minimumDeletions(String s) {
    int[] prefixa = new int[s.length()];
    int[] suffixb = new int[s.length()];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'b') {
        count++;
      }
      prefixa[i] = count;
    }
    count = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == 'a') {
        count++;
      }
      suffixb[i] = count;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      min = Math.min(min, prefixa[i] + suffixb[i]);
    }
    return min - 1;
  }
}
// @lc code=end
