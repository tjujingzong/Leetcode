/*
 * @lc app=leetcode.cn id=2544 lang=cpp
 *
 * [2544] Alternating Digit Sum
 */

// @lc code=start
class Solution {
 public:
  int alternateDigitSum(int n) {
    string sn = to_string(n);
    int ans = 0;
    for (int i = 0; i < sn.size(); i++) {
      if (i % 2 == 0) {
        ans += sn[i] - '0';
      } else {
        
        ans -= sn[i] - '0';
      }
    }
    return ans;
  }
};
// @lc code=end
