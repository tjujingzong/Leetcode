import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
  public int minTransfers(int[][] distributions) {
    int n = distributions.length;
    int[] shops = new int[12];
    for (int i = 0; i < n; i++) {
      int from = distributions[i][0];
      int to = distributions[i][1];
      int num = distributions[i][2];
      shops[from] -= num;
      shops[to] += num;
    }
    int p = 0;
    int ne = 0;
    for (int i = 0; i < 12; i++) {
      if (shops[i] > 0)
        p++;
      if (shops[i] < 0)
        ne++;
    }
    return Math.max(p, ne);
  }
}