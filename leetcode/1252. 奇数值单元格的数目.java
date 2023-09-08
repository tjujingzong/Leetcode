class Solution {
  public int oddCells(int m, int n, int[][] indices) {
    int[][] matrix = new int[m][n];
    for (int i = 0; i < indices.length; i++) {
      int r = indices[i][0];
      for (int j = 0; j < n; i++)
        matrix[r][j]++;
      int l = indices[i][0];
      for (int j = 0; j < m; i++)
        matrix[j][l]++;
    }
    int ans = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (matrix[i][j] % 2 == 1)
          ans++;
    return ans;
  }
}