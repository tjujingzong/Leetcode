/*
 * @lc app=leetcode.cn id=980 lang=cpp
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
 public:
  int total = 0;
  int startx, starty, endx, endy;
  int m, n;
  int ans = 0;
  int dx[4] = {0, 0, 1, -1};
  int dy[4] = {1, -1, 0, 0};
  bool visited[20][20];
  int uniquePathsIII(vector<vector<int>>& grid) {
    m = grid.size();
    n = grid[0].size();
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j] == 1) {
          startx = i;
          starty = j;
        } else if (grid[i][j] == 2) {
          endx = i;
          endy = j;
        } else if (grid[i][j] == 0) {
          total++;
        }
      }
    }

    memset(visited, false, sizeof(visited));
    visited[startx][starty] = true;
    dfs(grid, startx, starty, 0);

    return ans;
  }
  bool isvalid(int x, int y) {
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return false;
    }
    return true;
  }
  void dfs(vector<vector<int>>& grid, int x, int y, int count) {
    if (x == endx && y == endy) {
      if (count == total + 1) {
        ans++;
      }
    }
    for (int i = 0; i < 4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];
      if (isvalid(newx, newy) && !visited[newx][newy] &&
          grid[newx][newy] != -1) {
        visited[newx][newy] = true;
        dfs(grid, newx, newy, count + 1);
        visited[newx][newy] = false;
      }
    }
  }
};
// @lc code=end
