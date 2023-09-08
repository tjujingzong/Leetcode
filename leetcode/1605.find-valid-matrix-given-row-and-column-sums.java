/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] Find Valid Matrix Given Row and Column Sums
 */

// @lc code=start
class Solution {
  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int m = rowSum.length;
    int n = colSum.length;
    int[][] ans = new int[m][n];
    int i = 0, j = 0;
    while (i < m && j < n) {
      ans[i][j] = Math.min(rowSum[i], colSum[j]);
      rowSum[i] -= ans[i][j];
      colSum[j] -= ans[i][j];
      if (rowSum[i] == 0) {
        i++;
      }
      if (colSum[j] == 0)
        j++;
    }
    return ans;
  }
}
// @lc code=end
