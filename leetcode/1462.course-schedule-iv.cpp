/*
 * @lc app=leetcode.cn id=1462 lang=cpp
 *
 * [1462] Course Schedule IV
 */

// @lc code=start
class Solution {
 public:
  bool isde[105][105];
  vector<int> g[105];
  bool isvis[105];
  int nn;
  void dfs(int now, vector<int>& v) {
    isvis[now] = true;
    for (int& next : g[now]) {
      if (isvis[next]) {
        for (int i = 0; i < nn; i++) {
          if (isde[next][i]) {
            for (int& pre : v) {
              isde[pre][i] = true;
            }
          }
        }
        for (int& pre : v) {
          isde[pre][next] = true;
        }
        continue;
      }
      for (int& pre : v) {
        isde[pre][next] = true;
      }
      v.push_back(next);
      dfs(next, v);
      v.pop_back();
    }
  }
  vector<bool> checkIfPrerequisite(int n,
                                   vector<vector<int>>& prerequisites,
                                   vector<vector<int>>& queries) {
    memset(isde, 0, sizeof(isde));
    int indegree[n];
    nn = n;
    memset(indegree, 0, sizeof(indegree));
    for (vector<int>& pre : prerequisites) {
      int a = pre[0];
      int b = pre[1];
      g[a].push_back(b);
      indegree[b]++;
      isde[a][b] = 1;
    }
    for (int i = 0; i < n; i++) {
      if (indegree[i] != 0 || isvis[i])
        continue;
      vector<int> v;
      v.push_back(i);
      dfs(i, v);
    }
    vector<bool> ans;
    for (vector<int>& qr : queries) {
      int a = qr[0];
      int b = qr[1];
      ans.push_back(isde[a][b]);
    }
    return ans;
  }
};
// @lc code=end
