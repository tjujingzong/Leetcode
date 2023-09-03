/*
 * @lc app=leetcode.cn id=1654 lang=cpp
 *
 * [1654] Minimum Jumps to Reach Home
 */

// @lc code=start
class Solution {
 public:
  int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
    int n = 10000;
    int dp[n][2];
    memset(dp, 0x3f, sizeof(dp));
    for (auto f : forbidden) {
      dp[f][0] = -1;
      dp[f][1] = -1;
    }
    dp[0][0] = 0;
    queue<pair<int, int>> q;
    q.push({0, 0});
    while (!q.empty()) {
      auto [pos, step] = q.front();
      q.pop();
      if (pos + a < n && dp[pos + a][0] > step + 1) {
        dp[pos + a][0] = step + 1;
        q.push({pos + a, step + 1});
      }
      if (pos - b >= 0 && dp[pos - b][1] > step + 1) {
        dp[pos - b][1] = step + 1;
        if (pos - b + a < n && dp[pos - b + a][0] > step + 2) {
          dp[pos - b + a][0] = step + 2;
          q.push({pos - b + a, step + 2});
        }
      }
    }
    int ans = min(dp[x][0], dp[x][1]);
    return ans == 0x3f3f3f3f ? -1 : ans;
    }
};
// @lc code=end
