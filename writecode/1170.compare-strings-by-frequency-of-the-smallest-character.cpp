/*
 * @lc app=leetcode.cn id=1170 lang=cpp
 *
 * [1170] Compare Strings by Frequency of the Smallest Character
 */

// @lc code=start
class Solution {
 public:
  vector<int> numSmallerByFrequency(vector<string>& queries,
                                    vector<string>& words) {
    vector<int> res;
    vector<int> f;
    for (int i = 0; i < words.size(); i++) {
      f.push_back(fre(words[i]));
    }
    sort(f.begin(), f.end());
    for (int i = 0; i < queries.size(); i++) {
      int q = fre(queries[i]);
      int l = 0, r = f.size() - 1;
      if (r >= 0 && f[r] <= q) {
        res.push_back(0);
        continue;
      }
      while (l < r) {
        int mid = (l + r) / 2;
        if (f[mid] <= q) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      res.push_back(f.size() - l);
    }
    return res;
  }
  int fre(string s) {
    int res = 0;
    char min = 'z';
    for (int i = 0; i < s.size(); i++) {
      if (s[i] < min) {
        min = s[i];
        res = 1;
      } else if (s[i] == min) {
        res++;
      }
    }
    return res;
  }
};
// @lc code=end
