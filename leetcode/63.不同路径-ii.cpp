/*
 * @lc app=leetcode.cn id=63 lang=cpp
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution
{
public:
  int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
  {
    int m = obstacleGrid.size();
    int n = obstacleGrid[0].size();
    int dp[m][n];
    memset(dp, 0, sizeof(dp));
    if (obstacleGrid[0][0] == 1)
      return 0;
    dp[0][0] = 1;
    for (int i = 1; i < m; i++)
      if (obstacleGrid[i][0] == 1)
        break;
      else
        dp[i][0] = dp[i - 1][0];
    for (int i = 1; i < n; i++)
      if (obstacleGrid[0][i] == 1)
        break;
      else
        dp[0][i] = dp[0][i - 1];
    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        if (obstacleGrid[i][j] == 0)
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
    return dp[m - 1][n - 1];
  }
};
// @lc code=end
