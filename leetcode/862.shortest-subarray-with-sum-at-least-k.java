import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long[] presum = new long[n + 1];
    for (int i = 0; i < n; i++)
      presum[i + 1] = presum[i] + nums[i];
    int ans = n + 1;
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i <= n; i++) {
      Long cur = presum[i];
      while (!q.isEmpty() && cur - presum[q.peek()] >= k)
        ans = Math.min(ans, i - q.poll());
      while (!q.isEmpty() && presum[q.peekLast()] >= cur) {
        q.pollLast();
      }
      q.add(i);
    }
    return ans == n + 1 ? -1 : ans;
  }
}
// @lc code=end
