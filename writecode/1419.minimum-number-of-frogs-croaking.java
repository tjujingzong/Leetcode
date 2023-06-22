/*
 * @lc app=leetcode.cn id=1419 lang=java
 *
 * [1419] Minimum Number of Frogs Croaking
 */

// @lc code=start
class Solution {
  public int minNumberOfFrogs(String croakOfFrogs) {
    int[] count = new int[5];
    int frogs = 0;
    int maxFrogs = 0;
    for (char c : croakOfFrogs.toCharArray()) {
      int i = "croak".indexOf(c);
      count[i]++;
      if (i == 0) {
        maxFrogs = Math.max(maxFrogs, ++frogs);
      } else if (--count[i - 1] < 0) {
        return -1;
      } else if (i == 4) {
        --frogs;
      }
    }
    return frogs == 0 ? maxFrogs : -1;
  }
}
// @lc code=end
