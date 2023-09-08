import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
  public int minTransfers(int[][] distributions) {
    int n = distributions.length;
    int[] shops = new int[distributions.length];
    for (int i = 0; i < n; i++) {
      int from = distributions[i][0];
      int to = distributions[i][1];
      int num = distributions[i][2];
      shops[from] -= num;
      shops[to] -= num;
    }
    TreeSet<Integer> pMap = new TreeSet<>();
    TreeSet<Integer> nMap = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      if (shops[i] > 0)
        pMap.add(shops[i]);
      if (shops[i] < 0)
        nMap.add(shops[i]);
    }
    int co = 0;
    for (int p : pMap) {
      for (int f : nMap) {
        if (p + f == 0) {
          pMap.remove(p);
          nMap.remove(f);
          co++;
        }
      }
    }
    if (pMap.size() == 0)
      return co;
    else if (pMap.size() == nMap.size())
      return co + pMap.size() + 1;
    return co + Math.max(pMap, nMap);
  }
}