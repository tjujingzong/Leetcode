import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1807 lang=java
 *
 * [1807] Evaluate the Bracket Pairs of a String
 */

// @lc code=start
class Solution {
  public String evaluate(String s, List<List<String>> knowledge) {
    s = s.replace("(", "1(");
    s = s.replace(")", ")1");
    System.out.println(s);
    String[] ss = s.split("1");
    StringBuilder ans = new StringBuilder();
    Map<String, String> dict = new HashMap<String, String>();
    for (List<String> kd : knowledge) {
      dict.put(kd.get(0), kd.get(1));
    }
    for (String s1 : ss) {
      if (s1.length() == 0)
        continue;
      if (s1.charAt(0) != '(') {
        ans.append(s1);
        continue;
      }
      boolean replaced = false;
      String s2 = s1.substring(1, s1.length() - 1);
      if (dict.containsKey(s2))
        ans.append(dict.get(s2));
      else
        ans.append("?");
    }
    return ans.toString();
  }
}
// @lc code=end
