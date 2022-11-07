class Solution {
  public long countSubarrays(int[] nums, int minK, int maxK) {
      var ans = 0L;
      int n = nums.length, minI = -1, maxI = -1, i0 = -1;
      for (var i = 0; i < n; ++i) {
          var x = nums[i];
          if (x == minK) minI = i;
          if (x == maxK) maxI = i;
          if (x < minK || x > maxK) i0 = i; // 子数组不能包含 nums[i0]
          ans += Math.max(Math.min(minI, maxI) - i0, 0);
      }
      return ans;
  }
}
