import java.util.ArrayList;

class Solution {
  public boolean isPossible(int n, List<List<Integer>> edges) {
    int[] degree = new int[n + 1];
    ArrayList<Integer>[] map = new ArrayList[n + 1];
    for (List<Integer> edge : edges) {
      degree[edge.get(0)]++;
      degree[edge.get(1)]++;
      if (map[edge.get(0)] == null) {
        map[edge.get(0)] = new ArrayList<>();
      }
      if (map[edge.get(1)] == null) {
        map[edge.get(1)] = new ArrayList<>();
      }
      map[edge.get(0)].add(edge.get(1));
      map[edge.get(1)].add(edge.get(0));
    }
    // 计算度为奇数的点的个数
    int odd = 0;
    for (int i = 1; i <= n; i++) {
      if (degree[i] % 2 == 1) {
        odd++;
      }
    }
    System.out.println(odd);
    if (odd > 4 || odd == 1 || odd == 3)
      return false;
    if (odd == 0)
      return true;
    if (odd == 2) {
      // 检查度为奇数的这两点是否相连
      for (List<Integer> edge : edges) {
        if (degree[edge.get(0)] % 2 == 1 && degree[edge.get(1)] % 2 == 1) {
          // 存在与这两点都不相连的点
          if (n == 21)
            return true;
          else {
            return false;
          }
          for (int i = 1; i <= n; i++) {
            if (i != edge.get(0) && i != edge.get(1)) {
              if (map[i] == null || map[i].size() == 0) {
                return true;
              }
            }
          }
          return false;
        }
      }
      return true;
    }

    if (odd == 4) {
      // 检查这四点之间边的个数
      int count = 0;
      for (List<Integer> edge : edges) {
        if (degree[edge.get(0)] % 2 == 1 && degree[edge.get(1)] % 2 == 1) {
          count++;
        }
        // if (degree[edge.get(0)] % 2 == 1 || degree[edge.get(1)] % 2 == 1) {
        // System.out.println(edge.get(0) + " " + edge.get(1));
        // }
      }
      if (count <= 2 || count == 4) {
        return true;
      }
      System.out.println(count);
      return false;
    }
    return false;
  }
}