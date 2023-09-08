/*
 * @lc app=leetcode.cn id=2496 lang=cpp
 *
 * [2496] Maximum Value of a String in an Array
 */

// @lc code=start
class Solution {
 public:
  int maximumValue(vector<string>& strs) {
    int ans = 0;
    for (auto& str : strs) {
      bool flag = false;
      for (auto& c : str) {
        if (isalpha(c)) {
          flag = true;
        }
      }
      if (flag)
        ans = max(ans, int(str.size()));
      else {
        int num = stoi(str);
        ans = max(ans, num);
      }
    }
    return ans;
  }
};
// @lc code=end
