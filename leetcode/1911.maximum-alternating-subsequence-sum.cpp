/*
 * @lc app=leetcode.cn id=1911 lang=cpp
 *
 * [1911] Maximum Alternating Subsequence Sum
 */

// @lc code=start
class Solution {
 public:
  long long maxAlternatingSum(vector<int>& nums) {
    long long odd = 0, even = 0;
    for (int i = 0; i < nums.size(); ++i) {
      long long odd_ = max(odd, even - nums[i]);
      long long even_ = max(even, odd + nums[i]);
      odd = odd_;
      even = even_;
    }
    return even;
  }
};
// @lc code=end
