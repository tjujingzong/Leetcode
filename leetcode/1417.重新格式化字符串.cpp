/*
 * @lc app=leetcode.cn id=1417 lang=cpp
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution
{
public:
  string reformat(string s)
  {
    string ans = "";
    vector<char> vch;
    vector<int> vint;
    for (int i = 0; i < s.length(); i++)
    {
      if (isdigit(s[i]))
        vint.push_back(s[i]);
      if (isalpha(s[i]))
        vch.push_back(s[i]);
    }
    if (vch.size() - vint.size() == 1)
    {
      ans += vch[vch.size() - 1];
      for (int i = 0; i < vint.size(); i++)
      {
        ans += vint[i];
        ans += vch[i];
      }
    }
    if (vint.size() - vch.size() == 1)
    {
      ans += vint[vint.size() - 1];
      for (int i = 0; i < vch.size(); i++)
      {
        ans += vch[i];
        ans += vint[i];
      }
    }
    if (vint.size() == vch.size())
    {
      for (int i = 0; i < vint.size(); i++)
      {
        ans += vch[i];
        ans += vint[i];
      }
    }
    return ans;
  }
};
// @lc code=end
