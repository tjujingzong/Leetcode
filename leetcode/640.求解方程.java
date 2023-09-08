/*
 * @lc app=leetcode.cn id=640 lang=java
 *
 * [640] 求解方程
 */

// @lc code=start
//把 “-” 替换成 “+-”， 然后按 “+” 切割， F就可以分离出等号左右两边的 式子的每一项啦

class Solution {
  public String solveEquation(String equation) {
    int numx = 0;
    int num = 0;
    String[] twoparts = equation.split("=");
    int start = 0, end = 0;
    for (int i = 0; i < twoparts[0].length(); i++) {
      if (twoparts[0].charAt(i) == '+' || twoparts[0].charAt(i) == '-' || i == twoparts[0].length() - 1) {
        end = i;
        if (i == twoparts[0].length() - 1)
          end = twoparts[0].length();
        else if (i == 0)
          continue;
        String sub = twoparts[0].substring(start, end);
        if ("x".equals(sub))
          numx++;
        else if ("-x".equals(sub))
          numx--;
        else if (sub.endsWith("x"))
          numx += Integer.parseInt(sub.substring(0, sub.length() - 1));
        else
          num -= Integer.parseInt(sub);
        if (twoparts[0].charAt(i) == '+')
          start = end + 1;
        else
          start = end;
      }
    }
    start = 0;
    end = 0;
    for (int i = 0; i < twoparts[1].length(); i++) {
      if (twoparts[1].charAt(i) == '+' || twoparts[1].charAt(i) == '-' || i == twoparts[1].length() - 1) {

        end = i;
        if (i == twoparts[1].length() - 1)
          end = twoparts[1].length();
        else if (i == 0)
          continue;
        String sub = twoparts[1].substring(start, end);
        if ("x".equals(sub))
          numx--;
        else if ("-x".equals(sub))
          numx++;
        else if (sub.endsWith("x"))
          numx -= Integer.parseInt(sub.substring(0, sub.length() - 1));
        else
          num += Integer.parseInt(sub);
        if (twoparts[1].charAt(i) == '+')
          start = end + 1;
        else
          start = end;
      }
    }
    if (numx == 0 && num == 0)
      return "Infinite solutions";
    if (numx == 0)
      return "No solution";
    return "x=" + String.valueOf(num / numx);
  }
}
// @lc code=end
