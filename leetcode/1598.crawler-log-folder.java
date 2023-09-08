/*
 * @lc app=leetcode.cn id=1598 lang=java
 *
 * [1598] Crawler Log Folder
 */

// @lc code=start
class Solution {
  public int minOperations(String[] logs) {
    int ans = 0;
    for (String log : logs) {
      if (log.equals("./"))
        continue;
      if (log.equals("../"))
        ans = Math.max(ans - 1, 0);
      else
        ans++;
    }
    return ans;
  }
}
// @lc code=end
