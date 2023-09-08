import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> diffWaysToCompute(String expression) {
    List<Integer> ans = new ArrayList<>();
    if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*"))
      ans.add(Integer.parseInt(expression));
    for (int k = 0; k < expression.length(); k++) {
      if (expression.charAt(k) == '+') {
        List<Integer> left = diffWaysToCompute(expression.substring(0, k));
        List<Integer> right = diffWaysToCompute(expression.substring(k + 1, expression.length()));
        for (int i = 0; i < left.size(); i++)
          for (int j = 0; j < right.size(); j++)
            ans.add(left.get(i) + right.get(j));
      }
      if (expression.charAt(k) == '-') {
        List<Integer> left = diffWaysToCompute(expression.substring(0, k));
        List<Integer> right = diffWaysToCompute(expression.substring(k + 1, expression.length()));
        for (int i = 0; i < left.size(); i++)
          for (int j = 0; j < right.size(); j++)
            ans.add(left.get(i) - right.get(j));
      }
      if (expression.charAt(k) == '*') {
        List<Integer> left = diffWaysToCompute(expression.substring(0, k));
        List<Integer> right = diffWaysToCompute(expression.substring(k + 1, expression.length()));
        for (int i = 0; i < left.size(); i++)
          for (int j = 0; j < right.size(); j++)
            ans.add(left.get(i) * right.get(j));
      }
    }
    return ans;
  }
}