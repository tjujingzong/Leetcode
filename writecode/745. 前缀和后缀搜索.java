import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

class WordFilter {
  HashMap<Character, TreeSet<Integer>> map;
  String[] wString;

  public WordFilter(String[] words) {
    wString = words;
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      Character t = words[i].charAt(0);
      if (map.containsKey(t)) {
        TreeSet set = map.get(t);
        set.add(i);
      } else {
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);
        set.add(i);
        map.put(t, set);
      }
    }
  }

  public int f(String pref, String suff) {
    Character t = pref.charAt(0);
    if (!map.containsKey(t))
      return -1;
    TreeSet<Integer> set = map.get(t);
    for (Integer i : set) {
      if (wString[i].startsWith(pref) && wString[i].endsWith(suff))
        return i;
    }
    return -1;
  }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */