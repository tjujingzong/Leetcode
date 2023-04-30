class Solution {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int k = arr.length;
    int n = mat.length;
    int m = mat[0].length;
    int[] map = new int[k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[mat[i][j]] = i * m + j;
      }
    }
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < k; i++) {
      int index = map[arr[i]];
      int x = index / m;
      int y = index % m;
      visited[x][y] = true;
      if (check(visited, x, y))
        return i;
    }
    return -1;
  }

  private boolean check(boolean[][] visited, int x, int y) {
    return checkrow(visited, x, y) || checkcol(visited, x, y);
  }

  private boolean checkrow(boolean[][] visited, int x, int y) {
    for (int i = 0; i < visited[0].length; i++) {
      if (!visited[x][i])
        return false;
    }
    return true;
  }

  private boolean checkcol(boolean[][] visited, int x, int y) {
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i][y])
        return false;
    }
    return true;
  }
}