/*
 * @lc app=leetcode.cn id=1595 lang=cpp
 *
 * [1595] Minimum Cost to Connect Two Groups of Points
 */

// @lc code=start
class Solution {
 public:
  int connectTwoGroups(vector<vector<int>>& cost) {
    int siz1 = cost.size(), siz2 = cost[0].size();
    int dp[13][1 << 12];
    memset(dp, 0x3f, sizeof(dp));
    dp[0][0] = 0;
    for (int i = 0; i < siz1; i++) {
      for (int j = 0; j < (1 << siz2); j++) {
        for (int k = 0; k < siz2; k++) {
          if (j & (1 << k) == 0)  // 第二个集合中的点没有被选中
            continue;
          dp[i + 1][j] =
              min(dp[i + 1][j], dp[i + 1][j ^ (1 << k)] + cost[i][k]);
          dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + cost[i][k]);
          dp[i + 1][j] = min(dp[i + 1][j], dp[i][j ^ (1 << k)] + cost[i][k]);
        }
      }
    }
    return dp[siz1][(1 << siz2) - 1];
  }
};
// @lc code=end
