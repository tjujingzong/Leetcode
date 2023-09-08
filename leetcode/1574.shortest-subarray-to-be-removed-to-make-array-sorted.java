import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1574 lang=java
 *
 * [1574] Shortest Subarray to be Removed to Make Array Sorted
 */

// @lc code=start
class Solution {
  public int findLengthOfShortestSubarray(int[] arr) {
    int n = arr.length;
    int i = 0;
    while (i + 1 < n && arr[i] <= arr[i + 1])
      i++;
    if (i == n - 1)
      return 0;
    int j = n - 1;
    while (j > 0 && arr[j - 1] <= arr[j])
      j--;
    int res = Math.min(n - i - 1, j);
    for (int k = 0; k <= i; k++) {
      for (int l = j; l < n; l++) {
        if (arr[l] >= arr[k]) {
          res = Math.min(res, l - k - 1);
          break;
        }
      }
    }
    return res;

  }
}
// @lc code=end
