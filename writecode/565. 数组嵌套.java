class Solution {
  public int arrayNesting(int[] nums) {
    int n = nums.length;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      uf.union(i, nums[i]);
    }
    return uf.maxsize;
  }

  public class UnionFind {
    private int count; // 记录连通分量
    private int[] parent; // 节点x的根节点是parent[x]
    private int[] size;
    private int maxsize = 1;

    public UnionFind(int n) {
      this.count = n;
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
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
      int sum = size[rootP] + size[rootQ];
      size[rootQ] = sum;
      if (sum > maxsize)
        maxsize = sum;
    }

    private int find(int x) {
      while (parent[x] != x) {
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
}