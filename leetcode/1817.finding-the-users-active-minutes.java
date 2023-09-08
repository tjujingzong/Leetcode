import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1817 lang=java
 *
 * [1817] Finding the Users Active Minutes
 */

// @lc code=start
class Solution {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    int[] ans = new int[k];
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    for (int[] log : logs) {
      int id = log[0];
      int time = log[1];
      if (map.containsKey(id))
        map.get(id).add(time);
      else {
        HashSet<Integer> set = new HashSet<>();
        set.add(time);
        map.put(id, set);
      }
    }
    for (int key : map.keySet()) {
      int size = map.get(key).size();

      ans[size - 1]++;
    }
    return ans;
  }
}
// @lc code=end
