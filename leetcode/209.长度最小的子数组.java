/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int ans = Integer.MAX_VALUE;
    int[] sum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    for (int i = 1; i <= n; i++) {
      int s = sum[i];
      int d = s - target;
      int l = 0, r = i;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        if (sum[mid] <= d)
          l = mid;
        else
          r = mid - 1;
      }
      if (sum[r] <= d)
        ans = Math.min(ans, i - r);
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
// @lc code=end
