/*
 * @lc app=leetcode.cn id=1726 lang=cpp
 *
 * [1726] Tuple with Same Product
 */

// @lc code=start
class Solution {
 public:
  int tupleSameProduct(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    int n = nums.size();
    int ans = 0;
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        m[nums[i] * nums[j]]++;
      }
    }
    for (auto& it : m) {
      if (it.second > 1)
        ans += it.second * (it.second - 1) * 4;
    }
    return ans;
  }
};
// @lc code=end
