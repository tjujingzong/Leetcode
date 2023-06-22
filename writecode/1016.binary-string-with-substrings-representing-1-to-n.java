/*
 * @lc app=leetcode.cn id=1016 lang=java
 *
 * [1016] Binary String With Substrings Representing 1 To N
 */

// @lc code=start
class Solution {
  public boolean queryString(String s, int n) {
    for (int i = n; i > n / 2; i--) {
      if (!s.contains(Integer.toBinaryString(i))) {
        return false;
      }
    }
    return true;
  }
}
// @lc code=end
