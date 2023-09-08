
/*
 * @lc app=leetcode.cn id=754 lang=java
 *
 * [754] Reach a Number
 */

// @lc code=start
class Solution {
  public int reachNumber(int target) {
    if (target < 0)
      target = -target;
    if (target == 0 || target == 1)
      return target;
    int i = 0;
    while (true) {
      if (i * (i + 1) > target * 2)
        break;
      i += 1;
    }
    int left = i * (i - 1) / 2;
    int right = i * (i + 1) / 2;
    if (left == target)
      return i - 1;
    if ((right - left) % 2 == 1) {
      if ((target - left) % 2 == 1)
        return i;
      else
        return i + 2;
    } else {
      if ((target - left) % 2 == 1)
        return i + 1;
      else
        return i;
    }
  }
}
// @lc code=end
