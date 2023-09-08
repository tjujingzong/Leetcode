import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2363 lang=java
 *
 * [2363] Merge Similar Items
 */

// @lc code=start
class Solution {
  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    TreeMap<Integer, Integer> map1 = new TreeMap<>();
    for (int i = 0; i < items1.length; i++) {
      map1.put(items1[i][0], items1[i][1]);
    }
    for (int i = 0; i < items2.length; i++) {
      map1.put(items2[i][0], map1.getOrDefault(items2[i][0], 0) + items2[i][1]);
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int key : map1.keySet()) {
      List<Integer> list = new ArrayList<>();
      list.add(key);
      list.add(map1.get(key));
      ans.add(list);
    }
    return ans;
  }
}
// @lc code=end
