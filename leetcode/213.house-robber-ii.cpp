/*
 * @lc app=leetcode.cn id=213 lang=cpp
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
 public:
  int rob(vector<int>& nums) {
    int n = nums.size();
    int ans = nums[0];
    int dp1[n];
    for (int i = 0; i < n - 1; i++) {
      dp1[i] = nums[i];
      for (int j = i - 2; j >= 0; j--) {
        dp1[i] = max(dp1[j] + nums[i], dp1[i]);
      }
      ans = max(dp1[i], ans);
    }
    int dp2[n];
    for (int i = 1; i < n; i++) {
      dp2[i] = nums[i];
      for (int j = i - 2; j >= 1; j--) {
        dp2[i] = max(dp2[j] + nums[i], dp2[i]);
      }
      ans = max(dp2[i], ans);
    }
    return ans;
  }
};
// @lc code=end
