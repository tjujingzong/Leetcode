class Solution {
  public int maxSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int ans = 0;
    for (int i = 0; i + 2 < n; i++) {
      for (int j = 0; j + 2 < m; j++) {
        int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
            + grid[i + 1][j + 1]
            + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        ans = Math.max(ans, sum);
      }
    }
    return ans;
  }
}