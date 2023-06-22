/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int[] map = new int[60];
    int ans = 0;
    for (int t : time) {
      int mod = t % 60;
      int target = (60 - mod) % 60;
      ans += map[target];
      map[mod]++;
    }
    return ans;
  }
}
// @lc code=end
