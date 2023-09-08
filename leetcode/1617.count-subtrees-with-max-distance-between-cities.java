/*
 * @lc app=leetcode.cn id=1617 lang=java
 *
 * [1617] Count Subtrees With Max Distance Between Cities
 */

// @lc code=start
class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
      int[] ans = new int[n - 1];
      int[][] graph = new int[n][n];
      for (int[] edge : edges) {
        graph[edge[0] - 1][edge[1] - 1] = 1;
        graph[edge[1] - 1][edge[0] - 1] = 1;
      }
      
    }
}
// @lc code=end

