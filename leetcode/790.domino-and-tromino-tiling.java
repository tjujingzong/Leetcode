/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

// @lc code=start
class Solution {
  int mod = 1000000007;

  public int numTilings(int n) {
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;
    if (n == 3)
      return 5;
    long[] dp = new long[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;
    for (int i = 4; i <= n; i++) {
      dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;
    }
    return (int) dp[n];
  }
}
// @lc code=end
