import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      if (map.containsKey(groupSizes[i]))
        map.get(groupSizes[i]).add(i);
      else {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(i);
        map.put(groupSizes[i], arrayList);
      }
    }
    for (Integer i : map.keySet()) {
      if (map.get(i).size() == i) {
        result.add(map.get(i));
      } else {
        int p = 0;
        for (int j = 0; j < map.get(i).size() / i; j++) {
          ArrayList<Integer> l = new ArrayList<Integer>();
          for (int k = 0; k < i; k++) {
            l.add(map.get(i).get(p));
            p++;
          }
          result.add(l);
        }
      }
    }
    return result;
  }
}
// @lc code=end
