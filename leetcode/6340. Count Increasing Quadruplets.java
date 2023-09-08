// Given a 0-indexed integer array nums of size n containing all numbers from 1 to n, return the number of increasing quadruplets.

// A quadruplet (i, j, k, l) is increasing if:

// 0 <= i < j < k < l < n, and
// nums[i] < nums[k] < nums[j] < nums[l].

class Solution {
  public long countQuadruplets(int[] nums) {
    int n = nums.length;
    long sum = 0;
    int[] v = new int[n];// v[j] 应当指的是以 j 为 “中间“ 的、“132“ 模式的数量。
    for (int l = 0; l < n; l++) {
      int z = 0;// 在 j 之前的、小于 nums[l] 的数字个数。
      for (int j = 0; j < l; j++) {
        if (nums[l] > nums[j]) {
          sum += v[j];
          z++;
        } else {
          v[j] += z;
        }
      }
    }
    return sum;
  }
}