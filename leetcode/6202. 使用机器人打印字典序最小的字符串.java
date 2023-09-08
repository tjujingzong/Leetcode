import java.util.Stack;

class Solution {
  public String robotWithString(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    int[] arr = new int[26];
    for (int i = 0; i < n; i++) {
      int p = s.charAt(i) - 'a';
      arr[p]++;
    }
    Stack<Character> stk = new Stack<>();
    for (int i = 0; i < n; i++) {
      int p = s.charAt(i) - 'a';
      arr[p]--;
      stk.push(s.charAt(i));
      while (!stk.empty()) {
        int pp = stk.peek() - 'a';
        boolean isminst = true;
        for (int j = 0; j < pp; j++) {
          if (arr[j] > 0) {
            isminst = false;
            break;
          }
        }
        if (isminst) {
          sb.append(stk.pop());
        } else
          break;
      }
    }
    return sb.toString();
  }
}
