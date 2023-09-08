/*
 * @lc app=leetcode.cn id=1221 lang=cpp
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution
{
public:
  int balancedStringSplit(string s)
  {
    int ans = 0;
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); i++)
    {
      if (s[i] == 'L')
        left++;
      if (s[i] == 'R')
        right++;
      if (left == right)
      {
        ans++;
        left = 0;
        right = 0;
      }
    }
    return ans;
  }
};
// @lc code=end
