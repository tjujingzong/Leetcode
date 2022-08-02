import java.net.MalformedURLException;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n < 2)
      return s;
    int b = 0, maxlen = 1;
    boolean[][] dp = new boolean[n][n];
    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n; i++) {
        int j = i + l - 1;
        if (j >= n)
          break;
        if (s.charAt(i) != s.charAt(j))
          dp[i][j] = false;
        else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else
            dp[i][j] = dp[i + 1][j - 1];
        }
        if (dp[i][j] && j - i + 1 > maxlen) {
          maxlen = j - i + 1;
          b = i;
        }
      }
    }
    return s.substring(b, b + maxlen);
  }
}
// @lc code=end
