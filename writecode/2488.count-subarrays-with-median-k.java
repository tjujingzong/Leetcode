import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2488 lang=java
 *
 * [2488] Count Subarrays With Median K
 */

// @lc code=start
class Solution {
  public int countSubarrays(int[] nums, int k) {
    int kIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == k) {
        kIndex = i;
        break;
      }
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int ans = 0;
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < k) {
        sum--;
      } else if (nums[i] > k) {
        sum++;
      }
      if (i < kIndex) {
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      } else {
        ans += map.getOrDefault(sum, 0);
        ans += map.getOrDefault(sum - 1, 0);
      }
    }
    return ans;
  }
}
// @lc code=end
