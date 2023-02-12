import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 */

// @lc code=start
class Solution {
  public List<String> removeSubfolders(String[] folder) {
    HashMap<Integer, List<String>> map = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    for (String s : folder) {
      int i = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '/') {
          i++;
        }
      }
      map2.put(s, i);
      map.putIfAbsent(i, new ArrayList<>());
      map.get(i).add(s + "/");
    }
    List<String> list = new ArrayList<>();
    for (String s : folder) {
      int len = map2.get(s);
      boolean flag = true;
      ok: for (int i = 1; i < len; i++) {
        if (!map.containsKey(i))
          continue ok;
        for (String father : map.get(i)) {
          if (s.startsWith(father)) {
            flag = false;
            break ok;
          }
        }
      }
      if (flag) {
        list.add(s);
      }
    }
    return list;
  }
}
// @lc code=end
