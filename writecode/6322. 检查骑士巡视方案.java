import java.util.TreeMap;

class Solution {
  public boolean checkValidGrid(int[][] grid) {
    if (grid[0][0] != 0)
      return false;
    int n = grid.length;
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int key = grid[i][j];
        int pos = i * n + j;
        treeMap.put(key, pos);
      }
    }
    for (int i = 0; i < n * n - 1; i++) {
      int nowpos = treeMap.get(i);
      int nextpos = treeMap.get(i + 1);
      int nowx = nowpos / n;
      int nowy = nowpos % n;
      int nextx = nextpos / n;
      int nexty = nextpos % n;
      if (!check(nextx, nexty, nowx, nowy))
        return false;
    }
    return true;
  }

  private boolean check(int nextx, int nexty, int nowx, int nowy) {
    if (Math.abs(nowy - nexty) == 2 && Math.abs(nowx - nextx) == 1)
      return true;
    if (Math.abs(nowy - nexty) == 1 && Math.abs(nowx - nextx) == 2)
      return true;
    return false;
  }
}