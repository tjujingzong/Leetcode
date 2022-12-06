import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1805 lang=java
 *
 * [1805] Number of Different Integers in a String
 */

// @lc code=start
class Solution {
  public int numDifferentIntegers(String word) {
    HashSet<String> set = new HashSet<>();
    // 用正则表达式将字符分割
    String[] str = word.split("[a-z]+");
    for (String s : str) {

      if (s.matches("[0]+")) {
        set.add("0");
        continue;
      }
      // 去除前导0
      s = s.replaceFirst("^0*", "");
      if (s.length() > 0)
        set.add(s);
    }
    return set.size();
  }
}
// @lc code=end
