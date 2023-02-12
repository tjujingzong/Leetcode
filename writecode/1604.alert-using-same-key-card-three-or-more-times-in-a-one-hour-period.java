/*
 * @lc app=leetcode.cn id=1604 lang=java
 *
 * [1604] Alert Using Same Key-Card Three or More Times in a One Hour Period
 */

// @lc code=start
class Solution {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    List<String> res = new ArrayList<>();
    HashMap<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < keyName.length; i++) {
      String name = keyName[i];
      String time = keyTime[i];
      int hour = Integer.parseInt(time.substring(0, 2));
      int minute = Integer.parseInt(time.substring(3, 5));
      int total = hour * 60 + minute;
      if (!map.containsKey(name)) {
        map.put(name, new ArrayList<>());
      }
      map.get(name).add(total);
    }
    for (String name : map.keySet()) {
      List<Integer> list = map.get(name);
      Collections.sort(list);
      for (int i = 0; i < list.size() - 2; i++) {
        if (list.get(i + 2) - list.get(i) <= 60) {
          res.add(name);
          break;
        }
      }
    }
    Collections.sort(res);
    return res;
  }
}
// @lc code=end
