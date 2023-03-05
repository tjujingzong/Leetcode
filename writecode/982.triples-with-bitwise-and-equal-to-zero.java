import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=982 lang=java
 *
 * [982] Triples with Bitwise AND Equal To Zero
 */

// @lc code=start
class Solution {
  public int countTriplets(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        int key = nums[i] & nums[j];
        map.put(key, map.getOrDefault(key, 0) + 1);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      for (int key : map.keySet()) {
        if ((key & nums[i]) == 0) {
          res += map.get(key);
        }
      }
    }
    return res;
  }
}
// @lc code=end
