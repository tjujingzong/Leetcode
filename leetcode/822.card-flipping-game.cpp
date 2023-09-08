/*
 * @lc app=leetcode.cn id=822 lang=cpp
 *
 * [822] Card Flipping Game
 */

// @lc code=start
class Solution {
 public:
  int flipgame(vector<int>& fronts, vector<int>& backs) {
    set<int> same;
    for (int i = 0; i < fronts.size(); i++) {
      same.insert(fronts[i]);
      same.insert(backs[i]);
    }
    for (int i = 0; i < fronts.size(); i++) {
      if (fronts[i] == backs[i]) {
        same.erase(fronts[i]);
      }
    }

    if (same.size() == 0) {
      return 0;
    }
    int min = *same.begin();
    return min;
  }
};
// @lc code=end
