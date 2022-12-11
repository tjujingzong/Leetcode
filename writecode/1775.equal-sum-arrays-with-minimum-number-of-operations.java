/*
 * @lc app=leetcode.cn id=1775 lang=java
 *
 * [1775] Equal Sum Arrays With Minimum Number of Operations
 */

// @lc code=start
class Solution {
  public int minOperations(int[] nums1, int[] nums2) {
    // 1. 两个数组的和差值
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < nums1.length; i++) {
      sum1 += nums1[i];
    }
    for (int i : nums2)
      sum2 += i;
    int[] max = sum1 > sum2 ? nums1 : nums2;
    int[] min = sum1 > sum2 ? nums2 : nums1;
    if (1 * max.length > 6 * min.length)
      return -1;
    int diff = Math.abs(sum1 - sum2);
    // 2.排序
    Arrays.sort(max);
    Arrays.sort(min);
    int i = 0, j = max.length - 1;
    int count = 0;
    while (diff > 0) {
      if (i < min.length && j >= 0) {
        if (6 - min[i] > max[j] - 1) {
          diff -= 6 - min[i];
          i++;
        } else {
          diff -= max[j] - 1;
          j--;
        }
      } else if (i < min.length) {
        diff -= 6 - min[i];
        i++;
      } else {
        diff -= max[j] - 1;
        j--;
      }
      count++;
    }
    return count;
  }
}
// @lc code=end
