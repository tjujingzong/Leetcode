class Solution {
  public int nextGreaterElement(int n) {
      char[] nums = Integer.toString(n).toCharArray();
      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) {
          i--;
      }
      if (i < 0) {
          return -1;
      }

      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
          j--;
      }
      swap(nums, i, j);
      reverse(nums, i + 1);
      long ans = Long.parseLong(new String(nums));
      return ans > Integer.MAX_VALUE ? -1 : (int) ans;
  }

  public void reverse(char[] nums, int begin) {
      int i = begin, j = nums.length - 1;
      while (i < j) {
          swap(nums, i, j);
          i++;
          j--;
      }
  }

  public void swap(char[] nums, int i, int j) {
      char temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcod-mqf1/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。