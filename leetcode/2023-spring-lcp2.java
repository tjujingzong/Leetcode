import java.util.HashSet;

class Solution {
  public int adventureCamp(String[] expeditions) {
    HashSet<String> set = new HashSet<>();

    String[] temp = expeditions[0].split("->");
    for (int j = 0; j < temp.length; j++) {
      set.add(temp[j]);
    }
    set.add("");
    int ans = -1;
    int maxcount = 0;
    for (int i = 1; i < expeditions.length; i++) {
      temp = expeditions[i].split("->");
      int count = 0;
      HashSet<String> set2 = new HashSet<>();
      for (int j = 0; j < temp.length; j++) {
        if (!set.contains(temp[j]) && !set2.contains(temp[j])) {
          set2.add(temp[j]);
          count++;
          set.add(temp[j]);
        }
      }
      if (count > maxcount) {
        maxcount = count;
        ans = i;
      }

    }
    return ans;
  }
}