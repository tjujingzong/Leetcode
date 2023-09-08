/*
 * @lc app=leetcode.cn id=1749 lang=cpp
 *
 * [1749] Maximum Absolute Sum of Any Subarray
 */

// @lc code=start
class Solution {
 public:
  int maxAbsoluteSum(vector<int>& nums) {
    int maxSum = 0, minSum = 0, sum = 0;
    for (int num : nums) {
      sum += num;
      maxSum = max(maxSum, sum);
      minSum = min(minSum, sum);
    }
    return maxSum - minSum;
  }
};
// @lc code=end
