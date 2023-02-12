import java.util.Arrays;


//给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。

// 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：

// 0 <= i < j < n，且
// lower <= nums[i] + nums[j] <= upper
class Solution {
  public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    long ans = 0;
    for (int i = 0; i < nums.length; i++) {
      int l = i + 1, r = nums.length;
      while (l < r) {
        int mid = (l + r) / 2;
        if (nums[i] + nums[mid] < lower) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      int left = l;
      l = i + 1;
      r = nums.length;
      while (l < r) {
        int mid = (l + r) / 2;
        if (nums[i] + nums[mid] <= upper) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      int right = l;
      ans += right - left;
    }
    return ans;
  }
}