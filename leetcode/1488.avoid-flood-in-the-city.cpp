/*
 * @lc app=leetcode.cn id=1488 lang=cpp
 *
 * [1488] Avoid Flood in The City
 */

// @lc code=start
class Solution {
 public:
  vector<int> avoidFlood(vector<int>& rains) {
    vector<int> ans(rains.size(), -1);
    unordered_map<int, int> full;
    set<int> dry;
    for (int i = 0; i < rains.size(); ++i) {
      if (rains[i] == 0) {
        dry.insert(i);
      } else {
        if (full.count(rains[i])) {
          auto it = dry.upper_bound(full[rains[i]]);
          if (it == dry.end()) {
            return {};
          }
          ans[*it] = rains[i];
          dry.erase(it);
        }
        full[rains[i]] = i;
      }
    }
    for (auto it = dry.begin(); it != dry.end(); ++it) {
      ans[*it] = 1;  // 随便填一个，无事发生
    }
    return ans;
  }
};
// @lc code=end
