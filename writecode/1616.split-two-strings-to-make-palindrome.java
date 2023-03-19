/*
 * @lc app=leetcode.cn id=1616 lang=java
 *
 * [1616] Split Two Strings to Make Palindrome
 */

// @lc code=start
class Solution {
  public boolean checkPalindromeFormation(String a, String b) {
    int len = a.length();
    int i = 0;
    int j = len - 1;
    while (i < j) {
      if (a.charAt(i) != b.charAt(j)) {
        break;
      }
      i++;
      j--;
    }
    if (i >= j) {
      return true;
    }
    if (isPalindrome(a, i, j) || isPalindrome(b, i, j)) {
      return true;
    }
    i = 0;
    j = len - 1;
    while (i < j) {
      if (b.charAt(i) != a.charAt(j)) {
        break;
      }
      i++;
      j--;
    }
    if (i >= j) {
      return true;
    }
    return isPalindrome(a, i, j) || isPalindrome(b, i, j);
  }

  private boolean isPalindrome(String b, int i, int j) {
    while (i < j) {
      if (b.charAt(i) != b.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  } 
}
// @lc code=end
