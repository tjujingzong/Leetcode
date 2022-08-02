public class UnionFind {
  private int count; // 记录连通分量
  private int[] parent; // 节点x的根节点是parent[x]

  public UnionFind(int n) {// n为并查集中最大元素的值
    this.count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    parent[rootP] = rootQ; // parent[rootQ]=rootP 效果是一样的
    count--; // 两个分量合二为一
  }

  private int find(int x) {
    while (parent[x] != x) {
      parent[x] = parent[parent[x]];
      x = parent[x];
    }
    return x;
  }

  public boolean connected(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    return rootP == rootQ;
  }

  public int count() {
    return count;
  }
}
