/*
 * @lc app=leetcode.cn id=2337 lang=cpp
 *
 * [2337] Move Pieces to Obtain a String
 */

// @lc code=start
class Solution {
 public:
  bool canChange(string start, string target) {
    string s1 = "", s2 = "";
    vector<int> r1, r2, l1, l2;
    for (int i = 0; i < start.size(); i++) {
      if (start[i] == '_')
        continue;
      s1 += start[i];
      if (start[i] == 'L')
        l1.push_back(i);
      else
        r1.push_back(i);
    }
    for (int i = 0; i < target.size(); i++) {
      if (target[i] == '_')
        continue;
      s2 += target[i];
      if (target[i] == 'L')
        l2.push_back(i);
      else
        r2.push_back(i);
    }
    if (s1 != s2)
      return false;
    for (int i = 0; i < l1.size(); i++) {
      if (l1[i] < l2[i])
        return false;
    }
    for (int i = 0; i < r1.size(); i++) {
      if (r1[i] > r2[i])
        return false;
    }
    return true;
  }
};
// @lc code=end
