import java.util.HashSet;

class Solution {
  int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
  HashSet<int[]> result = new HashSet<int[]>();
  int maxstep;
  int n, m;

  public int[][] ballGame(int num, String[] plate) {
    n = plate.length;
    m = plate[0].length();
    char[][] grid = new char[n][m];
    maxstep = num;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = plate[i].charAt(j);
      }
    }
    for (int i = 1; i < n - 1; i++) {
      if (grid[i][0] == '.')
        dfs(grid, i, 0, 0, i, 0);
      if (grid[i][m - 1] == '.')
        dfs(grid, i, m - 1, 2, i, m - 1);
    }
    for (int j = 1; j < m - 1; j++) {
      if (grid[0][j] == '.')
        dfs(grid, 0, j, 1, 0, j);
      if (grid[n - 1][j] == '.')
        dfs(grid, n - 1, j, 3, n - 1, j);
    }
    int[][] ans = new int[result.size()][2];
    int p = 0;
    for (int[] i : result) {
      ans[p] = i;
      p++;
    }
    return ans;
  }

  void dfs(char[][] grid, int i, int j, int d, int bi, int bj) {
    int[] t = { bi, bj };
    int[] ks = dir[d];
    for (int k = 1; k <= maxstep; k++) {
      int nexti = i + ks[0] * k;
      int nextj = j + ks[1] * k;
      if (nexti >= n || nexti < 0 || nextj >= m || nextj < 0)
        break;
      if (grid[nexti][nextj] == 'O') {
        result.add(t);
        return;
      }
      if (grid[nexti][nextj] == 'E') {
        dfs(grid, nexti, nextj, (d + 1) % 4, bi, bj);
        break;
      }
      if (grid[nexti][nextj] == 'W') {
        dfs(grid, nexti, nextj, (d + 3) % 4, bi, bj);
        break;
      }
    }
  }
}