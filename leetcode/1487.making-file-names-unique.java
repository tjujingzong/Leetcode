/*
 * @lc app=leetcode.cn id=1487 lang=java
 *
 * [1487] Making File Names Unique
 */

// @lc code=start
class Solution {
  public String[] getFolderNames(String[] names) {
    String[] res = new String[names.length];
    Map<String, Integer> map = new HashMap<>();
    int i = 0;
    for (String s : names) {
      if (!map.containsKey(s)) {
        map.put(s, 1);
        res[i] = s;
      } else {
        int count = map.get(s);
        while (map.containsKey(s + "(" + count + ")")) {
          count++;
        }
        map.put(s, count + 1);
        map.put(s + "(" + count + ")", 1);
        res[i] = s + "(" + count + ")";
      }
      i++;
    }
    return res;
  }
}
// @lc code=end
