/*
 * @lc app=leetcode.cn id=2699 lang=java
 *
 * [2699] Modify Graph Edge Weights
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
    ArrayList<int[]>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int start = edge[0];
      int end = edge[1];
      int weight = edge[2];
      if (weight == -1)
        weight = 0;
      graph[start].add(new int[] { end, weight });
      graph[end].add(new int[] { start, weight });
    }
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int minDist = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = 0; j < n; j++) {
        if (!visited[j] && dist[j] < minDist) {
          minDist = dist[j];
          minIndex = j;
        }
      }
      if (minIndex == -1)
        break;
      visited[minIndex] = true;
      for (int[] edge : graph[minIndex]) {
        int end = edge[0];
        int weight = edge[1];
        if (dist[minIndex] + weight < dist[end]) {
          dist[end] = dist[minIndex] + weight;
        }
      }
    }
    ArrayList<int[]> result = new ArrayList<>();
    
  }
}
// @lc code=end
