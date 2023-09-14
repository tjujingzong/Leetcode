/*
 * @lc app=leetcode.cn id=1222 lang=cpp
 *
 * [1222] Queens That Can Attack the King
 */

// @lc code=start
class Solution {
 public:
  int dir[8][2] = {{0, 1},   {0, -1}, {-1, 0}, {1, 0},
                   {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens,
                                          vector<int>& king) {
    bool qu[8][8];
    memset(qu, 0, sizeof(qu));
    for (vector<int>& q : queens) {
      int x = q[0];
      int y = q[1];
      qu[x][y] = 1;
    }
    int kx = king[0];
    int ky = king[1];
    vector<vector<int>> ans;
    for (int i = 0; i < 8; i++) {
      int x = kx + dir[i][0];
      int y = kx + dir[i][1];
      while (x >= 0 && x < 8 && y >= 0 && y < 8) {
        if (qu[x][y]) {
          vector<int> q;
          q.push_back(x);
          q.push_back(y);
          ans.push_back(q);
          break;
        }
        x += dir[i][0];
        y += dir[i][1];
      }
    }
    return ans;
  }
};
// @lc code=end
