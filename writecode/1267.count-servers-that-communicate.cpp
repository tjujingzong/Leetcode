/*
 * @lc app=leetcode.cn id=1267 lang=cpp
 *
 * [1267] Count Servers that Communicate
 */

// @lc code=start
class Solution {
 public:
  int countServers(vector<vector<int>>& grid) {
    int ans = 0;
    int m = grid.size();
    int n = grid[0].size();
    set<int> row;
    set<int> col;
    for (int i = 0; i < m; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          cnt++;
        }
      }
      if (cnt > 1) {
        row.insert(i);
      }
    }
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < m; j++) {
        if (grid[j][i] == 1) {
          cnt++;
        }
      }
      if (cnt > 1) {
        col.insert(i);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && (row.count(i) || col.count(j))) {
          ans++;
        }
      }
    }
    return ans;
  }
};
// @lc code=end
