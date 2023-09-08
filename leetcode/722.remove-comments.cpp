/*
 * @lc app=leetcode.cn id=722 lang=cpp
 *
 * [722] Remove Comments
 */

// @lc code=start
class Solution {
 public:
  vector<string> removeComments(vector<string>& source) {
    vector<string> res;
    bool inBlock = false;
    string out;
    for (auto& s : source) {
      for (int i = 0; i < s.size(); i++) {
        if (!inBlock && i + 1 < s.size() && s[i] == '/' && s[i + 1] == '/') {
          break;
        } else if (!inBlock && i + 1 < s.size() && s[i] == '/' &&
                   s[i + 1] == '*') {
          inBlock = true;
          i++;
        } else if (inBlock && i + 1 < s.size() && s[i] == '*' &&
                   s[i + 1] == '/') {
          inBlock = false;
          i++;
        } else if (!inBlock) {
          out.push_back(s[i]);
        }
      }
      if (!inBlock && !out.empty()) {
        res.push_back(out);
        out.clear();
      }
    }
    return res;
  }
};
// @lc code=end
