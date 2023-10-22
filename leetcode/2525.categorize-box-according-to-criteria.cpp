/*
 * @lc app=leetcode.cn id=2525 lang=cpp
 *
 * [2525] Categorize Box According to Criteria
 */

// @lc code=start
class Solution {
 public:
  string categorizeBox(int length, int width, int height, int mass) {
    bool bulky = length >= 10000 || width >= 10000 || height >= 10000;
    bool heavy = mass >= 100;
    if (length >= (1e9 / height / width))
      bulky = true;
    if (bulky && heavy)
      return "Both";
    if (bulky)
      return "Bulky";
    if (heavy)
      return "Heavy";
    return "Neither";
  }
};
// @lc code=end