import java.util.Stack;

/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
  int mod = 1000000000 + 7;

  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    int[] left = new int[n];
    int[] right = new int[n];
    long ans = 0;
    for (int i = 0; i < n; i++) {
      int j = i + 1;
      for (j = i + 1; j < n; j++) {
        if (arr[j] < arr[i])
          break;
      }
      right[i] = j - i;
    }
    for (int i = n - 1; i >= 0; i--) {
      int j = i - 1;
      for (j = i - 1; j >= n; j--) {
        if (arr[j] < arr[i])
          break;
      }
      right[i] = i - j;
    }
    for (int i = 0; i < n; i++) {
      ans = (ans + (long) left[i] * right[i] * arr[i]) % mod;
      System.out.println(ans);
    }
    return (int) ans;
  }
}
// @lc code=end
