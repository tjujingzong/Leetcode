class Solution {
  private List<Integer>[] g;
  private int[] price;
  private long ans;

  public long maxOutput(int n, int[][] edges, int[] price) {
    this.price = price;
    g = new ArrayList[n];
    Arrays.setAll(g, e -> new ArrayList<>());
    for (var e : edges) {
      int x = e[0], y = e[1];
      g[x].add(y);
      g[y].add(x); // 建树
    }
    g[0].add(-1); // 防止根节点被认作叶子
    dfs(0, -1);
    return ans;
  }

  // 返回带叶子的最大路径和，不带叶子的最大路径和
  private long[] dfs(int x, int fa) {
    var p = price[x];
    if (g[x].size() == 1)
      return new long[] { p, 0 }; // 叶子
    long max_s1 = 0, max_s2 = 0;
    for (var y : g[x])
      if (y != fa) {
        var res = dfs(y, x);
        long s1 = res[0], s2 = res[1];
        if (max_s1 == 0) // 特判：第一颗子树，这个时候不能选当前节点
          ans = Math.max(ans, s1);
        else // 前面最大不带叶子的路径 + 当前节点 + 当前带叶子的路径
          ans = Math.max(ans, max_s2 + p + s1);
        // 前面最大带叶子的路径 + 当前节点 + 当前不带叶子的路径
        ans = Math.max(ans, max_s1 + p + s2);
        max_s1 = Math.max(max_s1, s1);
        max_s2 = Math.max(max_s2, s2);
      }
    return new long[] { max_s1 + p, max_s2 + p }; // 不是叶子节点，都可以加上当前节点的值
  }
}
