/*
 * @lc app=leetcode.cn id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 */

// @lc code=start
class Solution {
  public boolean isValid(String s) {
    if (s.contains("abc")) {
      return isValid(s.replace("abc", ""));
    }
    return s.isEmpty();
  }
}
// @lc code=end
