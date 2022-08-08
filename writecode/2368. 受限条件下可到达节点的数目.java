import java.util.HashSet;

class Solution {
  public int reachableNodes(int n, int[][] edges, int[] restricted) {
    HashSet<Integer> reset = new HashSet<>();
    for (int i = 0; i < restricted.length; i++) {
      reset.add(restricted[i]);
    }
    unionfind uf = new unionfind(n);
    for (int i = 0; i < edges.length; i++) {
      if (reset.contains(edges[i][0]) || reset.contains(edges[i][1]))
        continue;
      uf.union(edges[i][0], edges[i][1]);
    }
    return uf.size[uf.find(0)];
  }
}

class unionfind {
  int[] parent;
  int[] size;

  public unionfind(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int find(int x) {
    while (x != parent[x]) {
      x = parent[x];
    }
    return x;
  }

  public void union(int x, int y) {
    int rootx = find(x);
    int rooty = find(y);
    if (rootx == rooty)
      return;
    parent[rootx] = rooty;
    int totalsum = size[rootx] + size[rooty];
    size[rootx] = totalsum;
    size[rooty] = totalsum;
  }
}