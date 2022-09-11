import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int ans = 0;
    for (int i = 0; i < nums.length; i++)
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    for (Integer i : map.keySet()) {
      if (map.get(i) == 1)
        ans = i;
    }
    return ans;
  }
}
// @lc code=end
