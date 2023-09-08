import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    HashMap<String, Integer> map = new HashMap<>();
    String[] s1s = s1.split(" ");
    String[] s2s = s2.split(" ");
    for (int i = 0; i < s1s.length; i++) {
      if (map.containsKey(s1s[i]))
        map.put(s1s[i], map.get(s1s[i]) + 1);
      else
        map.put(s1s[i], 1);
    }
    for (int i = 0; i < s2s.length; i++) {
      if (map.containsKey(s2s[i]))
        map.put(s2s[i], map.get(s2s[i]) + 1);
      else
        map.put(s2s[i], 1);
    }
    ArrayList<String> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key) == 1)
        ans.add(key);
    }
    String[] anss = new String[ans.size()];
    for (int i = 0; i < anss.length; i++) {
      anss[i] = ans.get(i);
    }
    return anss;
  }
}
