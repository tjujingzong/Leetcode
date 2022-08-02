/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
  int[][] rowsum;
  int m, n;

  public NumMatrix(int[][] matrix) {
    m = matrix.length;
    n = matrix[0].length;
    rowsum = new int[m][n];
    for (int i = 0; i < m; i++)
      rowsum[i][0] = matrix[i][0];
    for (int i = 0; i < m; i++)
      for (int j = 1; j < n; j++)
        rowsum[i][j] = rowsum[i][j - 1] + matrix[i][j];
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int ans = 0;
    for (int i = row1; i <= row2; i++)
      ans += rowsum[i][col2];
    if (col1 >= 1) {
      for (int i = row1; i <= row2; i++)
        ans -= rowsum[i][col1 - 1];
    }
    return ans;
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
