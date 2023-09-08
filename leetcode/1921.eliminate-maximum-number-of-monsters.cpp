/*
 * @lc app=leetcode.cn id=1921 lang=cpp
 *
 * [1921] Eliminate Maximum Number of Monsters
 */

// @lc code=start
class Solution {
 public:
  int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
    int n = dist.size();
    int time[n];
    for (int i = 0; i < n; i++) {
      time[i] = (dist[i] + speed[i] - 1) / speed[i];
    }
    sort(time, time + n);
    for (int i = 0; i < n; i++) {
      if (time[i] <= i) {
        return i;
      }
    }
    return n;
  }
};
// @lc code=end
