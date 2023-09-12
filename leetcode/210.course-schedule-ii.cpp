/*
 * @lc app=leetcode.cn id=210 lang=cpp
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
 public:
  vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
    vector<int> ans;
    vector<vector<int>> g(numCourses);
    vector<int> in(numCourses);
    for (auto& p : prerequisites) {
      g[p[1]].push_back(p[0]);
      in[p[0]]++;
    }
    queue<int> q;
    for (int i = 0; i < numCourses; i++) {
      if (in[i] == 0) {
        q.push(i);
      }
    }
    while (!q.empty()) {
      int t = q.front();
      q.pop();
      ans.push_back(t);
      for (auto& x : g[t]) {
        in[x]--;
        if (in[x] == 0) {
          q.push(x);
        }
      }
    }
    if (ans.size() != numCourses) {
      return {};
    }
    return ans;
  }
};
// @lc code=end
