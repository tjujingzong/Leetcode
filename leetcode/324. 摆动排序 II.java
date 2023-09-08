class Solution {
  public void wiggleSort(int[] nums) {
      int[] arr = nums.clone();
      Arrays.sort(arr);
      int n = nums.length;
      int x = (n + 1) / 2;
      for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
          nums[i] = arr[j];
          if (i + 1 < n) {
              nums[i + 1] = arr[k];
          }
      }
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/wiggle-sort-ii/solution/bai-dong-pai-xu-ii-by-leetcode-solution-no0s/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。