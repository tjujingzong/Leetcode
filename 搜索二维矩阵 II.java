
class Solution {
  boolean ans = false;
  boolean[][] flag;
  int m, n;

  public boolean searchMatrix(int[][] matrix, int target) {
    m = matrix.length;
    n = matrix[0].length;
    flag = new boolean[m][n];
    bfs(matrix, 0, 0, target);
    return ans;
  }

  void bfs(int[][] matrix, int x, int y, int target) {
    if (target == matrix[x][y])
      ans = true;
    if (x == m || y == n || matrix[x][y] > target)
      return;
    flag[x][y] = true;
    if (x + 1 < n) {
      if (!flag[x + 1][y])
        bfs(matrix, x + 1, y, target);
    }

    if (y + 1 < m) {
      if (!flag[x][y + 1])
        bfs(matrix, x, y + 1, target);
    }
  }
}