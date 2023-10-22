/*
 * @lc app=leetcode.cn id=2530 lang=cpp
 *
 * [2530] Maximal Score After Applying K Operations
 */

// @lc code=start
class Solution {
 public:
  long long maxKelements(vector<int>& nums, int k) {
    priority_queue<int> pq;
    long long ans = 0;
    for (int i = 0; i < nums.size(); i++) {
      pq.push(nums[i]);
    }
    while (k--) {
      int top = pq.top();
      pq.pop();
      ans += top;
      pq.push((top - 1) / 3 + 1);
    }
    return ans;
  }
};
// @lc code=end
