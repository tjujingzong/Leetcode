import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1615 lang=java
 *
 * [1615] Maximal Network Rank
 */

// @lc code=start
class Solution {
  public int maximalNetworkRank(int n, int[][] roads) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] road : roads) {
      graph[road[0]].add(road[1]);
      graph[road[1]].add(road[0]);
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int rank = graph[i].size() + graph[j].size();
        if (graph[i].contains(j)) {
          rank--;
        }
        max = Math.max(max, rank);
      }
    }
    return max;
  }
}
// @lc code=end
