import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=899 lang=java
 *
 * [899] 有序队列
 */

// @lc code=start
class Solution {
  public String orderlyQueue(String s, int k) {
    StringBuilder tsb = new StringBuilder(s);
    String ans = s;
    int n = s.length();
    char[] c = new char[n];
    for (int i = 0; i < n; i++) {
      c[i] = s.charAt(i);
    }
    if (k == 1) {
      for (int i = 0; i < n; i++) {
        tsb = tsb.deleteCharAt(0);
        tsb.append(c[i]);
        if (ans.compareTo(tsb.toString()) >= 0)
          ans = tsb.toString();
      }
      return ans;
    }
    ans = "";
    Arrays.sort(c);
    for (char ch : c)
      ans += ch;
    return ans;
  }
}
// @lc code=end
