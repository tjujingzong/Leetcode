import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public int transportationHub(int[][] path) {
    int ans = -1;
    HashMap<Integer, Integer> tomap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> frommap = new HashMap<Integer, Integer>();
    HashSet<Integer> set = new HashSet<Integer>();
    for (int[] p : path) {
      set.add(p[0]);
      set.add(p[1]);
      tomap.put(p[1], tomap.getOrDefault(p[1], 0) + 1);
      tomap.put(p[0], tomap.getOrDefault(p[0], 0) + 1);
    }
    for (int i : tomap.keySet()) {
      if (tomap.get(i).equals(set.size() - 1) && !frommap.containsKey(i))
        ans = i;
    }
    return ans;
  }
}