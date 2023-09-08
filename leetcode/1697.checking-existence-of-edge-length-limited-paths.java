import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1697 lang=java
 *
 * [1697] Checking Existence of Edge Length Limited Paths
 */

// @lc code=start
class Solution {
  public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    int m = queries.length;
    Integer[] order = new Integer[m];
    for (int i = 0; i < m; i++) {
      order[i] = i;
    }
    Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
    Arrays.sort(order, (a, b) -> queries[a][2] - queries[b][2]);
    boolean[] ans = new boolean[m];
    UnionFind uf = new UnionFind(n);
    int idx = 0;
    for (int i : order) {
      int[] q = queries[i];
      while (idx < edgeList.length && edgeList[idx][2] < q[2]) {
        uf.union(edgeList[idx][0], edgeList[idx][1]);
        idx++;
      }
      ans[i] = uf.find(q[0]) == uf.find(q[1]);
    }
    return ans;
  }

  class UnionFind {
    int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int x) {
      if (parent[x] != x) {
        parent[x] = find(parent[x]);
      }
      return parent[x];
    }

    public void union(int x, int y) {
      if (find(x) == find(y))
        return;
      parent[find(x)] = find(y);
    }
  }
}
// @lc code=end
