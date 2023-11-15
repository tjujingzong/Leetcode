/*
 * @lc app=leetcode.cn id=1155 lang=cpp
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
 public:
  int numRollsToTarget(int n, int k, int target) {
    int dp[31][1001];
    memset(dp, 0, sizeof(dp));
    int mod = 1e9 + 7;
    for (int i = 1; i <= k; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        for (int l = j + 1; l <= target; l++) {
          dp[i][l] += dp[i - 1][l - j];
          dp[i][l] %= mod;
        }
      }
    }
    return dp[n][target];
  }
};
// @lc code=end
