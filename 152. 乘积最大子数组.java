
class Solution {
  public int maxProduct(int[] nums) {
      int maxF = nums[0], minF = nums[0], ans = nums[0];
      int length = nums.length;
      for (int i = 1; i < length; ++i) {
          int mx = maxF, mn = minF;
          maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
          minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
          ans = Math.max(maxF, ans);
      }
      return ans;
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。H 