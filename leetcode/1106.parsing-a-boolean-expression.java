import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 */

// @lc code=start
class Solution {
  public boolean parseBoolExpr(String e) {
    StringBuffer expression = new StringBuffer(e);
    Stack<Integer> charstack = new Stack<Integer>();
    Stack<Integer> boolstack = new Stack<Integer>();
    Stack<Integer> bracketstack = new Stack<Integer>();
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '!' || expression.charAt(i) == '&' || expression.charAt(i) == '|') {
        charstack.push(i);
      } else if (expression.charAt(i) == '(') {
        bracketstack.push(i);
      } else if (expression.charAt(i) == 't' || expression.charAt(i) == 'f') {
        boolstack.push(i);
      } else if (expression.charAt(i) == ')') {
        Integer left = charstack.pop();
        Character c = expression.charAt(left);
        boolean t;
        int p = 0;
        if (c == '|')
          t = false;
        else
          t = true;
        int leftbracket = bracketstack.pop();
        while (!boolstack.isEmpty() && boolstack.peek() > leftbracket) {
          p = boolstack.pop();
          boolean top = expression.charAt(p) == 't' ? true : false;
          if (c == '!')
            t = !top;
          else if (c == '&')
            t &= top;
          else
            t |= top;
        }
        boolstack.push(p);
        Character tt = t ? 't' : 'f';
        expression.setCharAt(p, tt);
      }
    }
    return expression.charAt(boolstack.pop()) == 't' ? true : false;
  }
}
// @lc code=end