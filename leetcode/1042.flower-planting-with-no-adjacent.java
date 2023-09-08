/*
 * @lc app=leetcode.cn id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 */

// @lc code=start
class Solution {
  public int[] gardenNoAdj(int n, int[][] paths) {
    int[] res = new int[n];
    List<Integer>[] graph = new List[n + 1];
    for (int i = 0; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < paths.length; i++) {
      int src = paths[i][0];
      int dst = paths[i][1];
      graph[src].add(dst);
      graph[dst].add(src);
    }
    for (int i = 1; i <= n; i++) {
      boolean[] used = new boolean[5];
      for (int j : graph[i]) {
        used[res[j - 1]] = true;
      }
      for (int j = 1; j <= 4; j++) {
        if (!used[j]) {
          res[i - 1] = j;
        }
      }
    }
    return res;
  }
}
// @lc code=end
