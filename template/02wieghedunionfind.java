class UnionFind {
  private Map<String, String> parent; // 记录每个节点的父节点
  HashMap<String, Double> valueMap = new HashMap<>();// 记录每个string对应的值

  public UnionFind(HashSet<String> StringSet) {
    parent = new HashMap<>();
    for (String s : StringSet) { // 初始化父节点为自身
      parent.put(s, s);
      valueMap.put(s, 1.0);// 初始赋权均为0
    }
  }

  public String find(String x) {
    if (!parent.containsKey(x)) {
      return null;
    }
    String root = x;
    double base = 1;
    while (!root.equals(parent.get(root))) {// 先从x找到根节点，并更新base为到根节点的权重
      root = parent.get(root);
      base *= valueMap.get(root);
    }
    while (!x.equals(root)) {// 更新从x到根节点路径上节点的权重
      String fatherString = parent.get(x);
      valueMap.put(x, valueMap.get(x) * base);
      base /= valueMap.get(fatherString);
      parent.put(x, root);// 压缩路径
      x = fatherString;
    }
    return root;
  }

  public void union(String x, String y, Double value) {
    String rootX = find(x);
    String rootY = find(y);
    if (rootX.equals(rootY)) {
      return;
    }
    parent.put(rootX, rootY);
    valueMap.put(rootX, value * valueMap.get(y) / valueMap.get(x));
  }
}
}