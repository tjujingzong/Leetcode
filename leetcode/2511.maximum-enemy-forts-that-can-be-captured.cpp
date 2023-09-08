/*
 * @lc app=leetcode.cn id=2511 lang=cpp
 *
 * [2511] Maximum Enemy Forts That Can Be Captured
 */

// @lc code=start
class Solution {
 public:
  int captureForts(vector<int>& forts) {
    int cur = 0, ans = 0;
    for (int i = 0; i < forts.size(); i++) {
      if (forts[cur] + forts[i] == 0) {
        ans = max(i - cur - 1, ans);
        cur = i;
      }
      if (forts[i] != 0) {
        cur = i;
      }
    }
    return ans;
  }
};
// @lc code=end
