/*
 * @lc app=leetcode.cn id=931 lang=cpp
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
 public:
  int minFallingPathSum(vector<vector<int>>& matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    vector<vector<int>> dp(n, vector<int>(m, 0x3f3f3f3f));
    for (int i = 0; i < m; i++)
      dp[0][i] = matrix[0][i];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j > 0)
          dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
        dp[i][j] = min(dp[i][j], dp[i - 1][j] + matrix[i][j]);
        if (j < m - 1)
          dp[i][j] = min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
      }
    }
    int ans = 0x3f3f3f3f;
    for (int i = 0; i < m; i++)
      ans = min(ans, dp[n - 1][i]);
    return ans;
  }
};
// @lc code=end
