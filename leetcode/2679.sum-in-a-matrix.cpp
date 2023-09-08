/*
 * @lc app=leetcode.cn id=2679 lang=cpp
 *
 * [2679] Sum in a Matrix
 */

// @lc code=start
class Solution {
 public:
  int matrixSum(vector<vector<int>>& nums) {
    for (int i = 0; i < nums.size(); i++) {
      sort(nums[i].begin(), nums[i].end());
    }
    int ans = 0;
    for (int j = 0; j < nums[0].size(); j++) {
      int maxx = 0;
      for (int i = 0; i < nums.size(); i++) {
        maxx = max(maxx, nums[i][j]);
      }
      ans += maxx;
    }
    return ans;
  }
};
// @lc code=end
