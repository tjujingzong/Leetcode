class Solution {
  public int rob(int[] nums) {
    int length = nums.length;
    if (length == 1) {
      return nums[0];
    } else if (length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
  }

  public int robRange(int[] nums, int start, int end) {
    int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2; i <= end; i++) {
      int temp = second;
      second = Math.max(first + nums[i], second);
      first = temp;
    }
    return second;
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/house-robber-ii/solution/da-jia-jie-she-ii-by-leetcode-solution-bwja/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。