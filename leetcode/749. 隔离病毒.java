import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
  public int containVirus(int[][] isInfected) {
    int m = isInfected.length, n = isInfected[0].length;
    int ans = 0;
    while (true) {
      UnionFind uf = new UnionFind(isInfected);
      TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();// 存病毒块
      for (int i = 0; i < m; i++) {// 构造并查集
        for (int j = 0; j < n; j++) {
          int landx = i * n + j;
          if (isInfected[i][j] == 1) { // 以下两行，如果右侧或下侧能够合并到当前岛中，合并之
            if (j < n - 1 && isInfected[i][j + 1] == 1)
              uf.union(landx, landx + 1);
            if (i < m - 1 && isInfected[i + 1][j] == 1)
              uf.union(landx, landx + n);
          }
        }
      }
      for (int i = 0; i < m * n; i++) {// 寻找病毒块
        if (isInfected[i / n][i % n] == 1) {
          int root = uf.find(i);
          if (map.containsKey(root)) {
            ArrayList list = map.get(root);
            list.add(i);
          } else {
            ArrayList list = new ArrayList<>();
            list.add(i);
            map.put(root, list);
          }
        }
      }
      if (map.isEmpty())
        break;
      TreeMap<Integer, Integer> lenthMap = new TreeMap<>();// 存围住感染区所需板子长度
      TreeMap<Integer, Integer> nextinjectMap = new TreeMap<>();// 存下次感染的面积
      int maxnextspread = 0;
      for (Integer root : map.keySet()) {
        int area = 0;
        ArrayList<Integer> vList = map.get(root);
        HashSet<Integer> pos = new HashSet<>();
        for (Integer index : vList) {
          int x = index / n, y = index % n;
          if (x >= 1 && isInfected[x - 1][y] == 0) {
            area++;
            pos.add(index - n);
          }
          if (x < m - 1 && isInfected[x + 1][y] == 0) {
            area++;
            pos.add(index + n);
          }
          if (y < n - 1 && isInfected[x][y + 1] == 0) {
            area++;
            pos.add(index + 1);
          }
          if (y >= 1 && isInfected[x][y - 1] == 0) {
            area++;
            pos.add(index - 1);
          }
        }
        lenthMap.put(root, area);
        nextinjectMap.put(root, pos.size());
        if (pos.size() > maxnextspread)
          maxnextspread = pos.size();
      }
      for (Integer index : lenthMap.keySet()) {// 围墙
        if (nextinjectMap.get(index) == maxnextspread) {
          ans += lenthMap.get(index);
          ArrayList<Integer> olList = map.get(index);
          for (Integer i : olList) {
            int x = i / n, y = i % n;
            isInfected[x][y] = 2;// 2表示被围起来，不会再扩散
          }
          map.remove(index);
          break;
        }
      }
      for (Integer root : map.keySet()) {// 剩下病毒扩散
        ArrayList<Integer> vList = map.get(root);
        for (Integer index : vList) {
          int x = index / n, y = index % n;
          if (x >= 1 && isInfected[x - 1][y] == 0)
            isInfected[x - 1][y] = 1;
          if (x < m - 1 && isInfected[x + 1][y] == 0)
            isInfected[x + 1][y] = 1;
          if (y < n - 1 && isInfected[x][y + 1] == 0)
            isInfected[x][y + 1] = 1;
          if (y >= 1 && isInfected[x][y - 1] == 0)
            isInfected[x][y - 1] = 1;
        }
      }
    }
    return ans;
  }

  private class UnionFind {
    private int[] parents;

    public UnionFind(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      this.parents = new int[m * n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1) { // 针对单格岛，赋值parents[k]和size[k]
            int k = i * n + j;
            parents[k] = k;
          }
        }
      }
    }

    // 带路径压缩的查找
    public int find(int x) {
      if (parents[x] == x)
        return x;
      return parents[x] = find(parents[x]);
    }

    // 按大小求并
    public void union(int x, int y) {
      int xRoot = find(x);
      int yRoot = find(y);
      if (xRoot != yRoot) {
        parents[yRoot] = xRoot;
      }
    }
  }
}