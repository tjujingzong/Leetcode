/*
 * @lc app=leetcode.cn id=2500 lang=cpp
 *
 * [2500] Delete Greatest Value in Each Row
 */

// @lc code=start
class Solution {
 public:
  int deleteGreatestValue(vector<vector<int>>& grid) {
    for (auto& row : grid)
      sort(row.begin(), row.end());
    int ans = 0;
    for (int i = 0; i < grid[0].size(); i++) {
      int temp = 0;
      for (int j = 0; j < grid.size(); j++) {
        temp = max(temp, grid[j][i]);
      }
      ans += temp;
    }
    return ans;
  }
};
// @lc code=end
