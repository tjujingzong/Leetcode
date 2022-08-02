import java.util.HashSet;

class Solution {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    int[] num = new int[n];
    for (int i = 0; i < n; i++)
      num[i] = i;
    UnionFind uf = new UnionFind(num);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        if (isConnected[i][j] == 1)
          uf.union(i, j);
    }
    HashSet set = new HashSet<Integer>();
    for (int i = 0; i < n; i++)
      set.add(uf.find(i));
    return set.size();
  }

  class UnionFind {
    // 记录每个节点的父节点
    private Map<Integer, Integer> parent;

    public UnionFind(int[] nums) {
      parent = new HashMap<>();
      // 初始化父节点为自身
      for (int num : nums) {
        parent.put(num, num);
      }
    }

    // 寻找x的父节点，实际上也就是x的最远连续右边界，这点类似于方法2
    public Integer find(int x) {
      // nums不包含x
      if (!parent.containsKey(x)) {
        return null;
      }
      // 遍历找到x的父节点
      while (x != parent.get(x)) {
        // 进行路径压缩，不写下面这行也可以，但是时间会慢些
        parent.put(x, parent.get(parent.get(x)));
        x = parent.get(x);
      }
      return x;
    }

    // 合并两个连通分量，在本题中只用来将num并入到num+1的连续区间中
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return;
      }
      parent.put(rootX, rootY);
    }
  }

}