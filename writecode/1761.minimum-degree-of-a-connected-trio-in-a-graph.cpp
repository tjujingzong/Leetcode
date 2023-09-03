/*
 * @lc app=leetcode.cn id=1761 lang=cpp
 *
 * [1761] Minimum Degree of a Connected Trio in a Graph
 */

// @lc code=start
class Solution {
 public:
  int minTrioDegree(int n, vector<vector<int>>& edges) {
    vector<vector<int>> graph(n + 1, vector<int>());
    vector<int> degree(n + 1, 0);
    for (vector<int> edge : edges) {
      degree[edge[0]]++;
      degree[edge[1]]++;
      if (edge[0] > edge[1])
        swap(edge[0], edge[1]);
      graph[edge[0]].push_back(edge[1]);
    }
    for (int i = 1; i <= n; i++) {
      sort(graph[i].begin(), graph[i].end());
    }
    int ans = INT_MAX;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < graph[i].size(); j++) {
        int k = j + 1;
        while (k < graph[i].size()) {
          if (binary_search(graph[graph[i][j]].begin(),
                            graph[graph[i][j]].end(), graph[i][k])) {
            ans = min(
                ans, degree[i] + degree[graph[i][j]] + degree[graph[i][k]] - 6);
          }
          k++;
        }
      }
    }
    return ans == INT_MAX ? -1 : ans;
  }
};
// @lc code=end
