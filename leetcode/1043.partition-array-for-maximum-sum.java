/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int n = arr.length;
    int[] dp = new int[n];
    dp[0] = arr[0];
    for (int i = 0; i < n; i++) {
      int max = arr[i];
      if (i >= 1)
        dp[i] = dp[i - 1] + max;
      for (int j = i - 1; j >= 0 && i - j < k; j--) {
        max = Math.max(max, arr[j]);
        if (j == 0) {
          dp[i] = Math.max(dp[i], max * (i - j + 1));
        } else {
          dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
        }
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[n - 1];
  }
}
// @lc code=end