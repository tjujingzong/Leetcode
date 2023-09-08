class Solution {
  public int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int[][] ans = new int[n - 2][n - 2];
    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < n - 2; j++) {
        for (int k = -1; k <= 1; k++) {
          for (int l = -1; l <= 1; l++) {
            if (i + k >= -1 && i + k < n - 1 && j + l >= -1 && j + l < n - 1)
              ans[i][j] = Math.max(ans[i][j], grid[i + 1 + k][j + 1 + l]);
          }
        }
      }
    }
    return ans;
  }
}