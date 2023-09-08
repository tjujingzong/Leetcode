import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] Mean of Array After Removing Some Elements
 */

// @lc code=start
class Solution {
  public double trimMean(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    double sum = 0.0;
    int d = n / 20;
    for (int i = d; i < n - d; i++)
      sum += (double) arr[i];
    return sum / (n - 2 * d);
  }
}
// @lc code=end
