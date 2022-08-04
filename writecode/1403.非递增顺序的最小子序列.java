import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
  public List<Integer> minSubsequence(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int sum = 0;
    for (int i : nums)
      sum += i;
    List<Integer> arraylist = new ArrayList<Integer>();
    int sum2 = 0;
    for (int i = n - 1; i >= 0; i--) {
      arraylist.add(nums[i]);
      sum2 += nums[i];
      sum -= nums[i];
      if (sum2 > sum)
        break;
    }
    return arraylist;
  }
}
// @lc code=end
