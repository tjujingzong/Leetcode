import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 == 1)
      return false;
    Stack<Character> q = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c.equals('(') || c.equals('{') || c.equals('['))
        q.add(c);
      else {
        if (q.isEmpty())
          return false;
        Character top = q.pop();
        if (top.equals('(') && c.equals(')'))
          continue;
        else if (top.equals('[') && c.equals(']'))
          continue;
        else if (top.equals('{') && c.equals('}'))
          continue;
        else
          return false;
      }
    }
    if (!q.isEmpty())
      return false;
    return true;
  }
}
// @lc code=end
