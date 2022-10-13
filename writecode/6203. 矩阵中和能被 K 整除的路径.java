class Solution {
  int mod = (int) 1E9 + 7;

  public int numberOfPaths(int[][] grid, int k) {
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n][m][k];
    dp[0][0][grid[0][0] % k] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int l = 0; l < k; l++) {
          int p = (l + grid[i][j]) % k;
          if (j - 1 >= 0)
            dp[i][j][p] += dp[i][j - 1][l];
          if (i - 1 >= 0)
            dp[i][j][p] += dp[i - 1][j][l];
          dp[i][j][p] %= mod;
        }
      }
    }
    return dp[n - 1][m - 1][0];
  }
}