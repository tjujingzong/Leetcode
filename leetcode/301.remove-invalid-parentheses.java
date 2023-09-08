import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
  ArrayList<String> res = new ArrayList<>();

  public List<String> removeInvalidParentheses(String s) {
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        left++;
      else if (s.charAt(i) == ')') {
        if (left == 0) {
          right++;
        } else {
          left--;
        }
      }
    }
    dfs(s, 0, left, right);
    return res;
  }

  void dfs(String s, int i, int left, int right) {
    if (left == 0 && right == 0) {
      if (isValid(s)) {
        res.add(s);
      }
      return;
    }
    for (int j = i; j < s.length(); j++) {
      if (j != i && s.charAt(j) == s.charAt(j - 1)) {
        continue;
      }
      if (s.charAt(j) == '(' || s.charAt(j) == ')') {
        String newS = s.substring(0, j) + s.substring(j + 1);
        if (right > 0 && s.charAt(j) == ')') {
          dfs(newS, j, left, right - 1);
        } else if (left > 0 && s.charAt(j) == '(') {
          dfs(newS, j, left - 1, right);
        }
      }
    }
  }

  boolean isValid(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        cnt++;
      } else if (str.charAt(i) == ')') {
        cnt--;
        if (cnt < 0) {
          return false;
        }
      }
    }
    return cnt == 0;
  }
}
// @lc code=end
