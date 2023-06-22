/*
 * @lc app=leetcode.cn id=2352 lang=java
 *
 * [2352] Equal Row and Column Pairs
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public int equalPairs(int[][] grid) {
    HashMap<String, Integer> rmap = new HashMap<>();
    HashMap<String, Integer> cmap = new HashMap<>();
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < grid[0].length; j++) {
        sb.append('-' + grid[i][j]);
      }
      String key = sb.toString();
      rmap.put(key, rmap.getOrDefault(key, 0) + 1);
    }
    for (int i = 0; i < grid[0].length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < grid.length; j++) {
        sb.append('-' + grid[j][i]);
      }
      String key = sb.toString();
      cmap.put(key, cmap.getOrDefault(key, 0) + 1);
    }
    for (String key : rmap.keySet()) {
      if (cmap.containsKey(key)) {
        count += rmap.get(key) * cmap.get(key);
      }
    }
    return count;
  }
}
// @lc code=end
