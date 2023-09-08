/*
 * @lc app=leetcode.cn id=221 lang=cpp
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution
{
public:
  int maximalSquare(vector<vector<char>> &matrix)
  {
    int m = matrix.size();
    int n = matrix[0].size();
    int dp[m][n];
    memset(dp, 0, sizeof(dp));
    int maxlength = 0;
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (matrix[i][j] == '1')
        {
          if (i == 0 || j == 0)
          {
            dp[i][j] = 1;
          }
          else
            dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          maxlength = max(maxlength, dp[i][j]);
        }
      }
    }
    return maxlength * maxlength;
  }
};
// @lc code=end
