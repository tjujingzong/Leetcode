/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
  public int maximumSwap(int num) {
    String ns = String.valueOf(num);
    StringBuilder sb = new StringBuilder(ns);
    Character maxc = sb.charAt(0);
    Integer l = 0, r = 0;
    boolean flag = false;
    for (int i = 0; i < ns.length(); i++) {
      if (flag)
        break;
      maxc = ns.charAt(i);
      for (int j = ns.length()-1; j >= i + 1; j--) {
        if (ns.charAt(j) > maxc) {
          maxc = ns.charAt(j);
          l = i;
          r = j;
          flag = true;
        }
      }
    }
    Character head = ns.charAt(l);
    sb.setCharAt(l, maxc);
    sb.setCharAt(r, head);
    return Integer.parseInt(sb.toString());
  }
}
// @lc code=end
