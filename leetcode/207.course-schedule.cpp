/*
 * @lc app=leetcode.cn id=207 lang=cpp
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
 public:
  bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
    vector<vector<int>> graph(numCourses);
    vector<int> indegree(numCourses, 0);
    for (auto p : prerequisites) {
      graph[p[1]].push_back(p[0]);
      indegree[p[0]]++;
    }
    queue<int> q;
    bool visited[numCourses];
    memset(visited, false, sizeof(visited));
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.push(i);
        visited[i] = true;
      }
    }
    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      for (auto next : graph[cur]) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.push(next);
          visited[next] = true;
        }
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }
};
// @lc code=end
