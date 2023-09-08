class Solution {
  public long countPairs(int n, int[][] edges) {
    UF uf = new UF(n);
    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }
    int[] size = uf.size();
    // 记录所有分支的大小
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      // 找到节点 i 的根节点
      // 注意：只有每个连通分量的根节点的 size[] 才可以代表该连通分量中的节点数
      int p = uf.find(i);
      // 已经加入 list 的节点直接跳过
      if (!set.contains(p))
        list.add(size[p]);
      set.add(p);
    }
    long ans = 0;
    // 计算结果
    int left = n;
    for (int sz : list) {
      ans += (long) sz * (n - sz);
      left -= sz;
    }
    // 注意 ➗ 2
    return ans / 2;
  }
}

/* ------------ 并查集模版 ------------ */
class UF {
  private int count;
  private int[] parent;
  private int[] size;

  public UF(int n) {
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
    if (rootP == rootQ)
      return;
    // 平衡性优化
    if (size[rootP] < size[rootQ]) {
      parent[rootP] = rootQ;
      size[rootQ] += size[rootP];
    } else {
      parent[rootQ] = rootP;
      size[rootP] += size[rootQ];
    }
    this.count--;
  }

  public boolean conneted(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    return rootP == rootQ;
  }

  public int count() {
    return this.count;
  }

  // 增加了一个函数
  // 返回 size[]
  public int[] size() {
    return this.size;
  }

  public int find(int x) {
    // 路径压缩
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}

// 作者：lfool
// 链接：https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/solution/by-lfool-6rtm/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。