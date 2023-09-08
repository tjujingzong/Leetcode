/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
  public int integerBreak(int n) {
    if (n <= 3)
      return n - 1;
    int ans = 1;
    int t = n / 3;
    if (n % 3 == 0)
      ans *= Math.pow(3, t);
    else if (n % 3 == 1)
      ans *= (4 * Math.pow(3, t - 1));
    else
      ans *= (2 * Math.pow(3, t));
    return ans;
  }
}
// @lc code=end
