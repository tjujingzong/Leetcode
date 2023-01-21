/*
 * @lc app=leetcode.cn id=1824 lang=java
 *
 * [1824] Minimum Sideway Jumps
 */

// @lc code=start
class Solution {
  public int minSideJumps(int[] obstacles) {
    int n = obstacles.length;
    int[][] dp = new int[n][3];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[0][2] = 1;
    for (int i = 1; i < n; i++) {

      for (int j = 0; j < 3; j++) {
        dp[i][j] = dp[i - 1][j];
      }
      if (obstacles[i] != 0)
        dp[i][obstacles[i] - 1] = Integer.MAX_VALUE;
      for (int j = 0; j < 3; j++) {
        if (obstacles[i] != j + 1)
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][(j + 1) % 3], dp[i][(j + 2) % 3]) + 1);
      }
    }
    for (int i = 0; i < n; i++)
      System.out.println(Arrays.toString(dp[i]));
    return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
  }
}
// @lc code=end
