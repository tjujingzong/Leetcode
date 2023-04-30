/*
 * @lc app=leetcode.cn id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
  public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
    int[] dp = new int[nums.length + 1];
    int[] dp2 = new int[nums.length + 1];
    int n = nums.length;
    int ans = 0;
    for (int i = 0; i < firstLen; i++) {
      dp[0] += nums[i];
    }
    for (int i = 1; i + firstLen - 1 < n; i++) {
      dp[i] = dp[i - 1] - nums[i - 1] + nums[i + firstLen - 1];
    }
    for (int i = 0; i < secondLen; i++) {
      dp2[firstLen] += nums[firstLen + i];
    }
    for (int i = firstLen + 1; i + secondLen - 1 < n; i++) {
      dp2[i] = dp2[i - 1] - nums[i - 1] + nums[i + secondLen - 1];
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + firstLen; j < n; j++) {
        ans = Math.max(ans, dp[i] + dp2[j]);
      }
      for (int j = i - secondLen; j >= 0; j--) {
        ans = Math.max(ans, dp[i] + dp2[j]);
      }
    }

    return ans;
  }
}
// @lc code=end
