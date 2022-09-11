import java.util.HashMap;

class Solution {
  public boolean checkDistances(String s, int[] distance) {
    int[] dis2 = new int[26];
    HashMap<Character, Integer> fMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!fMap.containsKey(s.charAt(i)))
        fMap.put(s.charAt(i), i);
      else
        dis2[s.charAt(i) - 'a'] = i - fMap.get(s.charAt(i)) - 1;
    }
    for (int i = 0; i < 26; i++) {
      if (!fMap.containsKey((char) (i + 'a')))
        continue;
      if (dis2[i] != distance[i])
        return false;
    }
    return true;
  }
}