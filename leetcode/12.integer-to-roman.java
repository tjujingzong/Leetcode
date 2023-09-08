import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
  public String intToRoman(int num) {
    String ans = "";
    TreeMap<Integer, String> map = new TreeMap<Integer, String>(((o1, o2) -> o2 - o1));
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");
    while (num > 0) {
      for (Integer i : map.keySet()) {
        if (i <= num) {
          ans += map.get(i);
          num -= i;
          break;
        }
      }
    }
    return ans;
  }

}
// @lc code=end
