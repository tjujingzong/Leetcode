class Solution {
  public int deleteGreatestValue(int[][] grid) {
    int ans = 0;
    // 对grid进行排序
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        for (int k = 0; k < grid[i].length; k++) {
          if (grid[i][j] > grid[i][k]) {
            int temp = grid[i][j];
            grid[i][j] = grid[i][k];
            grid[i][k] = temp;
          }
        }
      }
    }
    for (int i = 0; i < grid[0].length; i++) {
      int max = grid[0][i];
      // 找出每一列的最大值
      for (int j = 0; j < grid.length; j++) {
        if (grid[j][i] > max) {
          max = grid[j][i];
        }
      }
      ans += max;

    }
    return ans;
  }
}