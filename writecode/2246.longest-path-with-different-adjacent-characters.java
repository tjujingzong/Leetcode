import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=2246 lang=java
 *
 * [2246] Longest Path With Different Adjacent Characters
 */

// @lc code=start
class Solution {
  String s;
  ArrayList<Integer>[] graph;
  int max = 1;

  public int longestPath(int[] parent, String s) {
    this.s = s;
    int n = s.length();
    graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 1; i < n; i++) {
      graph[parent[i]].add(i);
    }
    dfs(0);
    return max;
  }

  private int dfs(int i) {
    if (graph[i].size() == 0) {
      return 1;
    }
    int max1 = 0;
    int max2 = 0;
    for (int j : graph[i]) {
      int temp = dfs(j);
      if (s.charAt(i) == s.charAt(j))
        continue; // skip the same char (i.e. same parent
      if (temp > max1) {
        max2 = max1;
        max1 = temp;
      } else if (temp > max2) {
        max2 = temp;
      }
    }
    max = Math.max(max, max1 + max2 + 1);
    return max1 + 1;
  }
}
// @lc code=end
