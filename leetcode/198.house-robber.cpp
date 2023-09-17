/*
 * @lc app=leetcode.cn id=198 lang=cpp
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
 public:
  int rob(vector<int>& nums) {
    int n = nums.size();
    int dp[n];
    memset(dp, 0, sizeof(0));
    int ans = 0;
    for (int i = 0; i < n; i++) {
      dp[i] = nums[i];
      for (int j = i - 2; j >= 0; j--) {
        dp[i] = max(dp[i], dp[j] + nums[i]);
      }
      ans = max(dp[i], ans);
    }
    return ans;
  }
};
// @lc code=end
