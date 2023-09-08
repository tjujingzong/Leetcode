class UnionFind {
  private Map<Integer, Integer> parent; // 记录每个节点的父节点

  public UnionFind(int[] nums) {
    parent = new HashMap<>();
    for (int num : nums) { // 初始化父节点为自身
      parent.put(num, num);
    }
  }

  public Integer find(int x) {
    if (!parent.containsKey(x)) {
      return null;
    }
    while (x != parent.get(x)) { // 遍历找到x的父节点
      // 进行路径压缩，不写下面这行也可以，但是时间会慢些
      parent.put(x, parent.get(parent.get(x)));
      x = parent.get(x);
    }
    return x;
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    parent.put(rootX, rootY);
  }
}
