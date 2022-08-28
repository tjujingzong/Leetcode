/*
 * @lc app=leetcode.cn id=1464 lang=cpp
 *
 * [1464] Maximum Product of Two Elements in an Array
 */

// @lc code=start
class Solution
{
public:
  int maxProduct(vector<int> &nums)
  {
    int max1 = 0, max2 = 0;
    for (int i = 0; i < nums.size(); i++)
    {
      if (max1 <= nums[i])
      {
        max2 = max1;
        max1 = nums[i];
      }
      else if (max2 < nums[i])
      {
        max2 = nums[i];
      }
    }
    return (max1 - 1) * (max2 - 1);
  }
};
// @lc code=end
