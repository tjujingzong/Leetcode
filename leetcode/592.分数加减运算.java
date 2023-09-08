/*
 * @lc app=leetcode.cn id=592 lang=java
 *
 * [592] 分数加减运算
 */

// @lc code=start
class Solution {
  public String fractionAddition(String expression) {
    if (!expression.startsWith("-"))
      expression = "+" + expression;
    int n = expression.split("-|\\+").length;
    String[] parts = expression.split("-|\\+");
    int[] numerator = new int[n];
    int[] denominator = new int[n];
    int commem = 1;
    int finalnumerator = 0;
    for (int i = 1; i < n; i++) {
      String[] parts2 = parts[i].split("/");
      numerator[i] = Integer.parseInt(parts2[0]);
      denominator[i] = Integer.parseInt(parts2[1]);
      commem *= denominator[i];
    }
    char[] sigh = new char[n];
    int j = 1;
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
        sigh[j++] = expression.charAt(i);
      }
    }
    for (int i = 1; i < n; i++) {
      if (sigh[i] == '+') {
        finalnumerator += commem / denominator[i] * numerator[i];
      } else if (sigh[i] == '-') {
        finalnumerator -= commem / denominator[i] * numerator[i];
      }
    }
    if (finalnumerator == 0)
      return "0/1";
    int r = Math.abs(gcd2(finalnumerator, commem));
    return String.valueOf(finalnumerator / r) + "/" + String.valueOf(commem / r);
  }

  public int gcd2(int p, int q) {
    int r;
    while (q != 0) {
      r = p % q;
      p = q;
      q = r;
    }
    return p;
  }
}
// @lc code=end
