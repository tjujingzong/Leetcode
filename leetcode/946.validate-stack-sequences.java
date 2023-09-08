import java.util.Stack;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stk = new Stack<>();
    int p = 0;
    for (int i = 0; i < pushed.length; i++) {
      stk.push(pushed[i]);
      while (!stk.isEmpty() && popped[p] == stk.peek()) {
        stk.pop();
        p++;
      }
    }
    return stk.isEmpty();
  }
}
// @lc code=end
