/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int start2 = Math.min(start, destination);
    int end2 = Math.max(start, destination);
    int sum1 = 0;
    int n = distance.length;
    for (int i = start2; i < end2; i++)
      sum1 += distance[i];
    int sum2 = 0;
    for (int i = 0; i < start2; i++)
      sum2 += distance[i];
    for (int i = end2; i < n; i++)
      sum2 += distance[i];
    return Math.min(sum1, sum2);
  }
}
// @lc code=end
