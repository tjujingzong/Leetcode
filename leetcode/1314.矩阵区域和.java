/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
class Solution {
  public int[][] matrixBlockSum(int[][] mat, int k) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] ans = new int[m][n];
    int[][] mat2 = new int[m][n];
    int i, j;
    for (j = 0; j < m; j++)
      for (i = 0; i < Math.min(k + 1, n); i++)
        mat2[j][0] += mat[j][i];
    for (i = 0; i < m; i++) {
      for (j = 1; j < n; j++) {
        mat2[i][j] = mat2[i][j - 1];
        if (j + k < n)
          mat2[i][j] += mat[i][j + k];
        if (j - k - 1 >= 0)
          mat2[i][j] -= mat[i][j - k - 1];
      }
    }
    for (j = 0; j < n; j++)
      for (i = 0; i < Math.min(k + 1, m); i++)
        ans[0][j] += mat2[i][j];
    for (i = 0; i < n; i++) {
      for (j = 1; j < m; j++) {
        ans[j][i] = ans[j - 1][i];
        if (j + k < m)
          ans[j][i] += mat2[j + k][i];
        if (j - k - 1 >= 0)
          ans[j][i] -= mat2[j - k - 1][i];
      }
    }
    return ans;
  }
}
// @lc code=end
