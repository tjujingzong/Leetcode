/*
 * @lc app=leetcode.cn id=1124 lang=java
 *
 * [1124] Longest Well-Performing Interval
 */

// @lc code=start
class Solution {
  public int longestWPI(int[] hours) {
    int n = hours.length;
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
    }
    int res = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n + 1; i++) {
      if (stack.isEmpty() || sum[stack.peek()] > sum[i]) {
        stack.push(i);
      }
    }
    for (int i = n; i >= 0; i--) {
      while (!stack.isEmpty() && sum[stack.peek()] < sum[i]) {
        res = Math.max(res, i - stack.pop());
      }
    }
    return res;
  }
}
// @lc code=end
