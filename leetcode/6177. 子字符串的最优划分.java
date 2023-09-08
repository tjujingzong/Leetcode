import java.util.TreeMap;

class Solution {
  public int partitionString(String s) {
    int start = 0;
    int ans = 1;
    TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (map.keySet().contains(c) && map.get(c) >= start) {
        ans++;
        start = i;
      }
      map.put(c, i);
    }
    return ans;
  }
}