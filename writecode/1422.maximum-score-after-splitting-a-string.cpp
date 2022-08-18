/*
 * @lc app=leetcode.cn id=1422 lang=cpp
 *
 * [1422] Maximum Score After Splitting a String
 */

// @lc code=start
class Solution
{
public:
  int maxScore(string s)
  {
    int ans = 0;
    for (int i = 1; i < s.size(); i++)
    {
      if (s[i] == '1')
        ans++;
    }
    int res = ans;
    for (int i = 0; i < s.size(); i++)
    {
      if (s[i] == '1' && i > 0)
        ans--;
      if (s[i] == '0' && i < s.size() - 1)
        ans++;
      res = max(res, ans);
    }
    return res;
  }
};
// @lc code=end
