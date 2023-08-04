/*
 * @lc app=leetcode.cn id=2050 lang=cpp
 *
 * [2050] Parallel Courses III
 */

// @lc code=start
class Solution {
 public:
  int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
    int ans = 0;
    vector<int> in(n + 1, 0);
    vector<vector<int>> out(n + 1);
    for (auto& r : relations) {
      out[r[0]].push_back(r[1]);
      in[r[1]]++;
    }
    vector<int> dp(n + 1, 0);
    queue<int> q;
    for (int i = 1; i <= n; i++) {
      if (in[i] == 0) {
        q.push(i);
        dp[i] = time[i - 1];
      }
    }
    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      for (auto& o : out[cur]) {
        in[o]--;
        dp[o] = max(dp[o], dp[cur] + time[o - 1]);
        if (in[o] == 0) {
          q.push(o);
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      ans = max(ans, dp[i]);
    }
    return ans;
  }
};
// @lc code=end
