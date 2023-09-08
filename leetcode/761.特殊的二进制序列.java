import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=761 lang=java
 *
 * [761] 特殊的二进制序列
 */

// @lc code=start
class Solution {
  public String makeLargestSpecial(String s) {
    if (s.length() <= 2)
      return s;
    int cnt = 0, left = 0;
    List<String> l = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1')
        cnt++;
      else
        cnt--;
      if (cnt == 0) {
        l.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
        left = i + 1;
      }
    }
    Collections.sort(l, Comparator.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (String sub : l) {
      sb.append(sub);
      // System.out.println(sub);
    }
    return sb.toString();
  }
}
// @lc code=end
