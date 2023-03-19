import java.util.ArrayDeque;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1625 lang=java
 *
 * [1625] Lexicographically Smallest String After Applying Operations
 */

// @lc code=start
class Solution {
  public String findLexSmallestString(String s, int a, int b) {
    HashSet<String> set = new HashSet<>();
    String ans = s;
    ArrayDeque<String> queue = new ArrayDeque<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      String cur = queue.poll();
      char[] chars = cur.toCharArray();
      for (int i = 1; i < chars.length; i += 2) {
        chars[i] = (char) (chars[i] + a >= '0' + 10 ? chars[i] + a - 10 : chars[i] + a);
      }
      String next1 = new String(chars);
      if (set.add(next1)) {
        queue.add(next1);
        if (next1.compareTo(ans) < 0) {
          ans = next1;
        }
      }
      String next2 = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
      if (set.add(next2)) {
        queue.add(next2);
        if (next2.compareTo(ans) < 0) {
          ans = next2;
        }
      }
    }
    return ans;
  }
}
// @lc code=end
