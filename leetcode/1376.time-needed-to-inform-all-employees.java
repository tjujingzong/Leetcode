/*
 * @lc app=leetcode.cn id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start
class Solution {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      if (manager[i] != -1)
        graph[manager[i]].add(i);
    }
    return dfs(graph, informTime, headID);
  }

  int dfs(ArrayList<Integer>[] graph, int[] informTime, int cur) {
    int max = 0;
    for (int i = 0; i < graph[cur].size(); i++) {
      max = Math.max(max, dfs(graph, informTime, graph[cur].get(i)));
    }
    return max + informTime[cur];
  }
}
// @lc code=end
