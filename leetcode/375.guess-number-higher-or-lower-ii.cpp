/*
 * @lc app=leetcode.cn id=375 lang=cpp
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
 public:
  int getMoneyAmount(int n) {
    if (n == 1)
      return 0;
    // 定义矩阵
    int dp[n + 1][n + 1];
    // 初始化“\”
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = INT_MAX;
      }
    }
    // 定义基础值dp[i][i]
    for (int i = 0; i <= n; i++) {
      dp[i][i] = 0;
    }

    // 按列来，从第2列开始
    for (int j = 2; j <= n; j++) {
      // 按行来，从下往上
      for (int i = j - 1; i >= 1; i--) {
        // 算除了两端的每一个分割点
        for (int k = i + 1; k <= j - 1; k++) {
          dp[i][j] = min(k + max(dp[i][k - 1], dp[k + 1][j]), dp[i][j]);
        }
        // 算两端
        dp[i][j] = min(dp[i][j], i + dp[i + 1][j]);
        dp[i][j] = min(dp[i][j], j + dp[i][j - 1]);
      }
    }
    return dp[1][n];
  }
};
// @lc code=end
