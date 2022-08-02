/*
 * @lc app=leetcode.cn id=392 lang=cpp
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution
{
public:
  bool isSubsequence(string s, string t)
  {
    int ps = 0, pt = 0;
    while (ps < s.length() && pt < t.length())
    {
      if (s[ps] == t[pt])
        ps++;
      pt++;
    }
    if (ps == s.length())
      return true;
    return false;
  }
};
// @lc code=end
