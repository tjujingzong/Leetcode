import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2341 lang=java
 *
 * [2341] Maximum Number of Pairs in Array
 */

// @lc code=start
class Solution {
  public int[] numberOfPairs(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] res = new int[2];
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    for (int key : map.keySet()) {
      int value = map.get(key);
      if (value >= 2) {
        res[0] += value / 2;
        res[1] += value % 2;
      } else {
        res[1] += value;
      }
    }
    return res;
  }
}
// @lc code=end
