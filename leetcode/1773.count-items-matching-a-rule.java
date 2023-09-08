import java.util.List;

/*
 * @lc app=leetcode.cn id=1773 lang=java
 *
 * [1773] Count Items Matching a Rule
 */

// @lc code=start
class Solution {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int ans = 0;
    int checknum = 0;
    if (ruleKey.equals("color"))
      checknum = 1;
    if (ruleKey.equals("name"))
      checknum = 2;
    for (List<String> item : items) {
      if (item.get(checknum).equals(ruleValue))
        ans++;
    }
    return ans;
  }
}
// @lc code=end
