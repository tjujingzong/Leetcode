/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
  int m, n;
  int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
  int[][] ans;
  int longesrlen = 1;

  public int longestIncreasingPath(int[][] matrix) {
    m = matrix.length;
    n = matrix[0].length;
    ans = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        longesrlen = Math.max(longesrlen, dfs(i, j, matrix));
    return longesrlen;
  }

  private int dfs(int i, int j, int[][] matrix) {// k为以i，j结束的长度
    if (ans[i][j] != 0)
      return ans[i][j];
    ans[i][j]++;
    for (int[] dir : dirs) {
      int ni = i + dir[0], nj = j + dir[1];
      if (reached(ni, nj) && matrix[ni][nj] > matrix[i][j]) {
        ans[i][j] = Math.max(ans[i][j], dfs(ni, nj, matrix) + 1);
      }
    }
    return ans[i][j];
  }

  private boolean reached(int i, int j) {
    if (i < 0 || j < 0 || i >= m || j >= n)
      return false;
    return true;
  }
}
// @lc code=end
