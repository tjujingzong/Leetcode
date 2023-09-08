import java.util.HashSet;

class Solution {
  public int flipgame(int[] fronts, int[] backs) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] != backs[i])
        set.add(fronts[i]);
        set.add(backs[i]);
    }
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] == backs[i])
        set.remove(fronts[i]);
    }
    if (set.isEmpty())
      return 0;
    int ans = 2001;
    for (Integer e : set) {
      if (e < ans)
        ans = e;
    }
    return ans;
  }
}