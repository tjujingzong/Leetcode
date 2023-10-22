/*
 * @lc app=leetcode.cn id=2591 lang=cpp
 *
 * [2591] Distribute Money to Maximum Children
 */

// @lc code=start
class Solution {
 public:
  int distMoney(int money, int children) {
    if (children > money)
      return -1;
    int ans = 0;
    money -= children;
    for (int i = 0; i < children; i++) {
      if (money >= 7 && i != children - 1) {
        if (money == 10 && i == children - 2)
          break;
        money -= 7;
        ans++;
      }
      if (money == 7 && i == children - 1)
        ans++;
    }
    return ans;
  }
};
// @lc code=end
