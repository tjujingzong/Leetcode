/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
  public String reverseVowels(String s) {
    String Vowels = "aeiouAEIOU";
    StringBuilder sb = new StringBuilder(s);
    StringBuilder allvowels = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Vowels.contains(s.subSequence(i, i + 1))) {
        allvowels.append(s.charAt(i));
      }
    }
    allvowels.reverse();
    int p = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Vowels.contains(s.subSequence(i, i + 1))) {
        sb.replace(i, i + 1, allvowels.substring(p, p + 1));
        p++;
      }
    }
    return sb.toString();
  }
}
// @lc code=end
