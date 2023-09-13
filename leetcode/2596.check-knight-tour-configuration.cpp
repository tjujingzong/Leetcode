/*
 * @lc app=leetcode.cn id=2596 lang=cpp
 *
 * [2596] Check Knight Tour Configuration
 */

// @lc code=start
class Solution {
 public:
  struct p {
    int x, y;
  };

  bool checkValidGrid(vector<vector<int>>& grid) {
    int n = grid.size();
    vector<p> pos(n * n);
    if (grid[0][0] != 0)
      return false;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        pos[grid[i][j]] = {i, j};
    for (int i = 0; i < n * n - 1; i++) {
      int j = i + 1;
      if (abs(pos[i].x - pos[j].x) * abs(pos[i].y - pos[j].y) != 2)
        return false;
    }
    return true;
  }
};
// @lc code=end
