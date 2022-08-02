import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    k = k % (n * m);
    ArrayList<Integer> lArrayList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i * n + j >= m * n - k)
          lArrayList.add(grid[i][j]);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        lArrayList.add(grid[i][j]);
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      List<Integer> littlelist = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        littlelist.add(lArrayList.get(i * n + j));
      }
      ans.add(littlelist);
    }
    return ans;
  }
}
// @lc code=end
