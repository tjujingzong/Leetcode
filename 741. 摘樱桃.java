class Solution {
  // 应该用动态规划
  int[][] grids;
  int[][] grids2;
  int ans1 = 0;
  int ans2 = 0;
  int n;

  public int cherryPickup(int[][] grid) {
    n = grid.length;
    grids = grid;
    grids2 = new int[n][n];
    to(0, 0, grids[0][0]);

    return ans1 + ans2;
  }

  public void to(int x, int y, int num) {
    if (x == n - 1 && y == n - 1) {
      if (num != 0) {
        ans1 = num;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            grids2[i][j] = grids[i][j];
          }
        }
        to2(0, 0, grids2[0][0]);
      }
    }
    if (avilible(x + 1, y)) {
      if (grids[x + 1][y] == 1) {
        grids[x + 1][y] = 0;
        to(x + 1, y, num + 1);
        grids[x + 1][y] = 1;
      } else
        to(x + 1, y, num);
    }
    if (avilible(x, y + 1)) {
      if (grids[x][y + 1] == 1) {
        grids[x][y + 1] = 0;
        to(x, y + 1, num + 1);
        grids[x][y + 1] = 1;
      } else
        to(x, y + 1, num);
    }
  }

  public void to2(int x, int y, int num) {
    if (x == n - 1 && y == n - 1) {
      if (num > ans2) {
        ans2 = num;
      }
    }
    if (avilible2(x + 1, y)) {
      if (grids2[x + 1][y] == 1) {
        grids2[x + 1][y] = 0;
        to(x + 1, y, num + 1);
        grids2[x + 1][y] = 1;
      } else
        to2(x + 1, y, num);
    }
    if (avilible2(x, y + 1)) {
      if (grids2[x][y + 1] == 1) {
        grids2[x][y + 1] = 0;
        to2(x, y + 1, num + 1);
        grids2[x][y + 1] = 1;
      } else
        to2(x, y + 1, num);
    }
  }

  public boolean avilible(int x, int y) {
    if (x <= n - 1 && x >= 0 && y <= n - 1 && y >= 0 && grids[x][y] != -1)
      return true;
    return false;
  }

  public boolean avilible2(int x, int y) {
    if (x <= n - 1 && x >= 0 && y <= n - 1 && y >= 0 && grids2[x][y] != -1)
      return true;
    return false;
  }
}