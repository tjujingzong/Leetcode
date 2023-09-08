/*
 * @lc app=leetcode.cn id=57 lang=cpp
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
 public:
  vector<vector<int>> insert(vector<vector<int>>& intervals,
                             vector<int>& newInterval) {
    vector<vector<int>> ans;
    int left = newInterval[0], right = newInterval[1];
    for (int i = 0; i < intervals.size(); i++) {
      if (intervals[i][1] < left) {
        ans.push_back(intervals[i]);
      } else if (intervals[i][0] > right) {
        ans.push_back({left, right});
        left = intervals[i][0];
        right = intervals[i][1];
      } else {
        left = min(left, intervals[i][0]);
        right = max(right, intervals[i][1]);
      }
    }
    ans.push_back({left, right});
    return ans;
  }
};
// @lc code=end
