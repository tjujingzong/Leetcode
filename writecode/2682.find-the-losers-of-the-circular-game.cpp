/*
 * @lc app=leetcode.cn id=2682 lang=cpp
 *
 * [2682] Find the Losers of the Circular Game
 */

// @lc code=start
class Solution {
 public:
  vector<int> circularGameLosers(int n, int k) {
    vector<int> ans;
    int cnt[n + 1];
    memset(cnt, 0, sizeof(cnt));
    int i = 1, c = 1;
    cnt[1] = 1;
    while (true) {
      i += c * k;
      i %= n;
      cnt[i]++;
      c++;
      if (cnt[i] > 1) {
        break;
      }
    }

    for (int i = 1; i < n; i++) {
      if (cnt[i] == 0) {
        ans.push_back(i);
      }
    }
    if (cnt[0] == 0)
      ans.push_back(n);
    return ans;
  }
};
// @lc code=end
