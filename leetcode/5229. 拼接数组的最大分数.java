
class Solution {
  public int maximumsSplicedArray(int[] nums1, int[] nums2) {
      return Math.max(solve(nums1, nums2), solve(nums2, nums1));
  }

  int solve(int[] nums1, int[] nums2) {
      int s1 = 0, maxSum = 0;
      for (int i = 0, s = 0; i < nums1.length; ++i) {
          s1 += nums1[i];
          s = Math.max(s + nums2[i] - nums1[i], 0);
          maxSum = Math.max(maxSum, s);
      }
      return s1 + maxSum;
  }
}

// 作者：endlesscheng
// 链接：https://leetcode.cn/problems/maximum-score-of-spliced-array/solution/by-endlesscheng-fm8l/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。