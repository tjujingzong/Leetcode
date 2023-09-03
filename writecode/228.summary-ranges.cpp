/*
 * @lc app=leetcode.cn id=228 lang=cpp
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
 public:
  vector<string> summaryRanges(vector<int>& nums) {
    vector<string> res;
    if (nums.size() == 0)
      return res;
    int start = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] != nums[i - 1] + 1) {
        if (start != nums[i - 1])
          res.push_back(to_string(start) + "->" + to_string(nums[i - 1]));
        else
          res.push_back(to_string(start));
        start = nums[i];
      }
    }
    if (start != nums[nums.size() - 1])
      res.push_back(to_string(start) + "->" + to_string(nums[nums.size() - 1]));
    else
      res.push_back(to_string(start));
    return res;
  }
};
// @lc code=end
