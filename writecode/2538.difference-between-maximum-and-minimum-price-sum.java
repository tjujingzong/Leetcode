import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=2538 lang=java
 *
 * [2538] Difference Between Maximum and Minimum Price Sum
 */

// @lc code=start
class Solution {
  long ans = 0;
  ArrayList<Integer>[] g;
  int[] price;

  public long maxOutput(int n, int[][] edges, int[] price) {
    g = new ArrayList[n];
    this.price = price;
    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList<>();
    }
    for (int[] edgesItem : edges) {
      g[edgesItem[0]].add(edgesItem[1]);
      g[edgesItem[1]].add(edgesItem[0]);
    }
    dfs(0, -1);
    return ans;
  }

  private long[] dfs(int x, int fa) {
    long p = price[x], maxS1 = p, maxS2 = 0;
    for (var y : g[x])
      if (y != fa) {
        var res = dfs(y, x);
        long s1 = res[0], s2 = res[1];
        // 前面最大带叶子的路径和 + 当前不带叶子的路径和
        // 前面最大不带叶子的路径和 + 当前带叶子的路径和
        ans = Math.max(ans, Math.max(maxS1 + s2, maxS2 + s1));
        maxS1 = Math.max(maxS1, s1 + p);
        maxS2 = Math.max(maxS2, s2 + p); // 这里加上 p 是因为 x 必然不是叶子
      }
    return new long[] { maxS1, maxS2 };
  }

}
// @lc code=end
