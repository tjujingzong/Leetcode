/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0)
          dp[0][j] = matrix[0][j];
        else if (j == 0)
          dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
        else if (j == n - 1)
          dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
        else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + matrix[i][j];
        }
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i : dp[n - 1])
      if (ans > i)
        ans = i;
    return ans;
  }
}
// @lc code=end
