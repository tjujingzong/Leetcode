import java.util.HashMap;
import java.util.HashSet;
/*
执行用时：
30 ms, 在所有 Java 提交中击败了55.70%的用户
内存消耗：
42.1 MB, 在所有 Java 提交中击败了64.02%的用户
 */
class MagicDictionary {
  HashMap<Integer, HashSet<String>> map;

  public MagicDictionary() {
    map = new HashMap<>();
  }

  public void buildDict(String[] dictionary) {
    for (int i = 0; i < dictionary.length; i++) {
      int len = dictionary[i].length;
      if (map.containsKey(len)) {
        HashSet<String> set = map.get(len);
        set.add(dictionary[i]);
      } else {
        HashSet<String> set = new HashSet<>();
        set.add(dictionary[i]);
        map.put(len, set);
      }
    }
  }

  public boolean search(String searchWord) {
    int n = searchWord.length();
    if (!map.containsKey(n))
      return false;
    HashSet<String> set=map.get(n);
    for (String s : set) {
      int diff = 0;
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) != searchWord.charAt(i))
          diff++;
      }
      if (diff == 1)
        return true;
    }
    return false;
  }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */