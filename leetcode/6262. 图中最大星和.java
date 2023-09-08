import java.util.ArrayList;

class Solution {
  public int maxStarSum(int[] vals, int[][] edges, int k) {
    int n = vals.length;
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++)
      graph[i] = new ArrayList<>();
    for (int[] edge : edges) {
      graph[edge[0]].add(vals[edge[1]]);
      graph[edge[1]].add(vals[edge[0]]);
    }
    int ans = -100000;
    // 对graph排序
    for (int i = 0; i < n; i++) {
      graph[i].sort((a, b) -> b - a);
      int sum = vals[i];
      for (int j = 0; j < k && j < graph[i].size(); j++)
        if (graph[i].get(j) > 0)
          sum += graph[i].get(j);
      ans = Math.max(ans, sum);
    }
    return ans;
  }
}