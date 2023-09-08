import java.util.*;

class Solution {
  private List<List<Integer>> graph;
  private int[] price;
  private int[] depth;
  private int[][] parent;
  private int[][][] dp;

  public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
    graph = new ArrayList<>();
    this.price = price;
    depth = new int[n];
    parent = new int[n][17];
    dp = new int[n][n][1 << n];

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
      Arrays.fill(parent[i], -1);
      for (int j = 0; j < n; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    dfs(0, -1, 0);

    // Build LCA parent array
    for (int k = 1; k < 17; k++) {
      for (int i = 0; i < n; i++) {
        if (parent[i][k - 1] != -1) {
          parent[i][k] = parent[parent[i][k - 1]][k - 1];
        }
      }
    }

    int ans = 0;
    for (int[] trip : trips) {
      ans += minimumCost(trip[0], trip[1], (1 << n) - 1);
    }

    return ans;
  }

  private void dfs(int node, int parentNode, int dep) {
    depth[node] = dep;
    parent[node][0] = parentNode;

    for (int neighbor : graph.get(node)) {
      if (neighbor == parentNode)
        continue;

      dfs(neighbor, node, dep + 1);
    }
  }

  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      int temp = u;
      u = v;
      v = temp;
    }

    for (int k = 16; k >= 0; k--) {
      if (depth[u] - (1 << k) >= depth[v]) {
        u = parent[u][k];
      }
    }

    if (u == v)
      return u;

    for (int k = 16; k >= 0; k--) {
      if (parent[u][k] != parent[v][k]) {
        u = parent[u][k];
        v = parent[v][k];
      }
    }

    return parent[u][0];
  }

  private int minimumCost(int u, int v, int mask) {
    if (u == v)
      return 0;
    if (dp[u][v][mask] != -1) {
      return dp[u][v][mask];
    }

    int lcaNode = lca(u, v);
    int cost = 0;

    while (u != lcaNode) {
      cost += ((mask >> u) & 1) == 1 ? price[u] / 2 : price[u];
      u = parent[u][0];
    }

    while (v != lcaNode) {
      cost += ((mask >> v) & 1) == 1 ? price[v] / 2 : price[v];
      v = parent[v][0];
    }

    cost += ((mask >> lcaNode) & 1) == 1 ? price[lcaNode] / 2 : price[lcaNode];

    dp[u][v][mask] = cost;

    return cost;
  }
}
