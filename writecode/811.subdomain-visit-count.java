import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
  List<String> ans = new ArrayList<String>();
  HashMap<String, Integer> map = new HashMap<>();

  public List<String> subdomainVisits(String[] cpdomains) {
    for (String s : cpdomains) {
      String[] twoparts = s.split(" ");
      int times = Integer.parseInt(twoparts[0]);
      dfs(twoparts[1], times);
    }
    for (String s : map.keySet()) {
      ans.add(String.valueOf(map.get(s)) + " " + s);
    }
    return ans;
  }

  public void dfs(String s, int t) {
    map.put(s, map.getOrDefault(s, 0) + t);
    if (s.contains("."))
      dfs(s.substring(s.indexOf(".") + 1, s.length()), t);
  }
}
// @lc code=end
