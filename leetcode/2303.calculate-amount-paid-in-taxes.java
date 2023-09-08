/*
 * @lc app=leetcode.cn id=2303 lang=java
 *
 * [2303] Calculate Amount Paid in Taxes
 */

// @lc code=start
class Solution {
  public double calculateTax(int[][] brackets, int income) {
    double ans = 0;
    if (income <= brackets[0][0])
      return income * brackets[0][1];
    ans += brackets[0][0] * brackets[0][1];
    income -= brackets[0][0];
    for (int i = 1; i < brackets.length; i++) {
      if (income > (brackets[i][0] - brackets[i - 1][0])) {
        ans += (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1];
        income -= brackets[i][0] - brackets[i - 1][0];
      } else {
        ans += income * brackets[i][1];
        break;
      }
    }
    return ans;
  }
}
// @lc code=end
