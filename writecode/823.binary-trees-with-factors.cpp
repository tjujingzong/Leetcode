/*
 * @lc app=leetcode.cn id=823 lang=cpp
 *
 * [823] Binary Trees With Factors
 */

// @lc code=start
class Solution {
 public:
  int numFactoredBinaryTrees(vector<int>& arr) {
    sort(arr.begin(), arr.end());
    unordered_map<int, long> dp;
    long res = 0;
    for (int i = 0; i < arr.size(); i++) {
      dp[arr[i]] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] % arr[j] != 0)
          continue;
        else if (dp.count(arr[i] / arr[j])) {
          dp[arr[i]] += dp[arr[j]] * dp[arr[i] / arr[j]];
        }
      }
    }
    for (auto& it : dp) {
      res += it.second;
    }
    return res % (int)(1e9 + 7);
  }
};
// @lc code=end
