/*
 * @lc app=leetcode.cn id=1289 lang=cpp
 *
 * [1289] Minimum Falling Path Sum II
 */

// @lc code=start
class Solution {
 public:
  int minFallingPathSum(vector<vector<int>>& grid) {
    int n = grid.size();
    vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
    for (int i = 0; i < n; i++) {
      dp[0][i] = grid[0][i];
    }
    int ans = INT_MAX;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (j == k)
            continue;
          dp[i][j] = min(dp[i - 1][k] + grid[i][j], dp[i][j]);
        }
      }
    }
    for (int j = 0; j < n; j++) {
      ans = min(ans, dp[n - 1][j]);
    }
    return ans;
  }
};
// @lc code=end
