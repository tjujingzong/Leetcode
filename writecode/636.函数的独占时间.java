import java.util.Stack;

/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] ans = new int[n];
    Stack<Integer> stk = new Stack<>();
    int cur = -1;
    for (String log : logs) {
      String[] times = log.split(":");
      int idx = Integer.parseInt(times[0]);
      int ts = Integer.parseInt(times[2]);
      if (times[1].equals("start")) {
        if (!stk.isEmpty())
          ans[stk.peek()] += ts - cur;
        stk.push(idx);
        cur = ts;
      } else {
        int func = stk.pop();
        ans[func] += ts - cur + 1;
        cur = ts + 1;
      }
    }
    return ans;
  }

}
// @lc code=end
