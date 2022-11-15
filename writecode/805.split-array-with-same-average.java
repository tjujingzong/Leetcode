
/*
 * @lc app=leetcode.cn id=805 lang=java
 *
 * [805] Split Array With Same Average
 */

// @lc code=start
class Solution {
  public boolean splitArraySameAverage(int[] nums) {
    // 折半枚举
    int n = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int[][] dp = new int[n / 2 + 1][sum + 1];
    for (int i = 0; i <= n / 2; i++) {
      for (int j = 0; j <= sum; j++) {
        dp[i][j] = -1;
      }
    }
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = n / 2; j >= 1; j--) {
        for (int k = sum; k >= nums[i]; k--) {
          if (dp[j - 1][k - nums[i]] >= 0) {
            dp[j][k] = i;
          }
        }
      }
    }
    for (int i = 1; i <= n / 2; i++) {
      if (sum * i % n == 0 && dp[i][sum * i / n] >= 0) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
