import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1691 lang=java
 *
 * [1691] Maximum Height by Stacking Cuboids 
 */

// @lc code=start
class Solution {
  public int maxHeight(int[][] cuboids) {
    int n = cuboids.length;
    boolean[] used = new boolean[n];
    int[] dp = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      Arrays.sort(cuboids[i]);
      max = Math.max(max, dfs(cuboids, used, dp, i));
    }
    return max;
  }

  int dfs(int[][] cuboids, boolean[] used, int[] dp, int i) {
    if (used[i])
      return dp[i];
    used[i] = true;
    int max = 0;
    for (int j = 0; j < cuboids.length; j++)
      if (cuboids[i][0] <= cuboids[j][0] && cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2])
        max = Math.max(max, dfs(cuboids, used, dp, j));
    dp[i] = max + cuboids[i][2];
    return dp[i];
  }

}
// @lc code=end
