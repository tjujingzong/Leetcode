class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] tempmatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        tempmatrix[i][j] = matrix[i][j];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        matrix[j][n - 1 - i] = tempmatrix[i][j];
    }
  }
}