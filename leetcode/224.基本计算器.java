
/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
  public int calculate(String s) {
    String ans = "";
    s = s.replaceAll(" ", "");// 先去空格
    int res = 0;
    int left = 0, right = 0;
    while (s.contains("(")) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(')
          left = i;
        if (s.charAt(i) == ')') {
          right = i;
          s = s.substring(0, left) + String.valueOf(calculate(s.substring(left + 1, right))) + s.substring(right + 1);
          s = s.replaceAll("--", "+");
          break;
        }
      }
    }
    ans = s.replaceAll("-", "+-");
    String[] nums = ans.split("\\+");
    for (int i = 0; i < nums.length; i++)
      if ("".equals(nums[i]))
        continue;
      else
        res += Integer.parseInt(nums[i]);
    return res;
  }
}
// @lc code=end
