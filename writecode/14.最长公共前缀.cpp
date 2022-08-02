/*
 * @lc app=leetcode.cn id=14 lang=cpp
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution
{
public:
  string longestCommonPrefix(vector<string> &strs)
  {
    string ans = "";
    int n = strs.size();
    int p = 0;
    bool flag = 1;
    while (1)
    {
      if (p >= strs[0].size())
        break;
      char a = strs[0][p];
      for (int i = 1; i < n; i++)
      {
        if (p > strs[i].size() || strs[i][p] != a)
        {
          flag = 0;
          break;
        }
      }
      if (flag)
      {
        p++;
        ans += a;
      }
      else
        break;
    }
    return ans;
  }
};
// @lc code=end
