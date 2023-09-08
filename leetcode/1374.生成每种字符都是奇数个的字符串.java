/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
class Solution {
  public String generateTheString(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n - 1; ++i) {
      sb.append("a");
    }
    if (n % 2 == 1)
      sb.append("a");
    else
      sb.append("b");
    return sb.toString();

  }
}
// @lc code=end
