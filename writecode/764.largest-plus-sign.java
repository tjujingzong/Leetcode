/*
 * @lc app=leetcode.cn id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start
class Solution {
  public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] grid = new int[n][n];
    for (int[] mine : mines)
      grid[mine[0]][mine[1]] = 1;
    for (int i = n / 2; i >= 1; i--) {
      for (int x = i; x < n - i; x++) {
        for (int y = i; y < n - i; y++) {
          if (grid[x][y] == 1 && cheak(x, y, grid, i))
            return i;
        }
      }
    }
  }

  private boolean cheak(int x, int y, int[][] grid, int i) {
    for (int j = 1; j <= i; j++) {
      if (grid[x + j][y] == 1 || grid[x - j][y] == 1 || grid[x][y + j] == 1 || grid[x][y - j] == 1)
        return false;
    }
    return true;
  }
}
// @lc code=end
