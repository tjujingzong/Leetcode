class Solution {
 public:
  long long continuousSubarrays(vector<int>& nums) {
    int n = nums.size();
    vector<int> dp(n, 0);
    dp[0] = 0;
    for (int i = 1; i < nums.size(); i++) {
      dp[i] = 0;
      for (int k = i - 1; k >= i - dp[i - 1] - 1; k--) {
        if (nums[i] - nums[k] == 0) {
          dp[i] = dp[i - 1] + 1;
          break;
        }
        if (Math.abs(nums[i] - nums[k]) <= 2) {
          dp[i] = dp[i] + 1;
        } else {
          break;
        }
      }
    }
    long long sum = 0;
    for (int j : dp) {
      sum += j;
    }
    return sum + nums.size();
  }
};