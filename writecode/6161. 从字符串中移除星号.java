import java.util.Stack;

class Solution {
  public String removeStars(String s) {
    Stack<Character> stk = new Stack<Character>();
    for (Character c : s.toCharArray()) {
      if (c.equals('*'))
        stk.pop();
      else
        stk.push(c);
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : stk) {
      sb.append(c);
    }
    return sb.toString();
  }
}