/*
 * @lc app=leetcode.cn id=2240 lang=cpp
 *
 * [2240] Number of Ways to Buy Pens and Pencils
 */

// @lc code=start
class Solution {
 public:
  long long waysToBuyPensPencils(int total, int cost1, int cost2) {
    long long ans = 0;
    for (int i = 0; i <= total; i += cost1) {
      ans += (total - i) / cost2 + 1;
    }
    return ans;
  }
};
// @lc code=end
