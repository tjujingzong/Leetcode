/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] Powerful Integers
 */

// @lc code=start
class Solution {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    int i = 0, j = 0;
    List<Integer> res = new ArrayList<>();
    Set<Integer> set = new TreeSet<>();
    while (Math.pow(x, i) <= bound) {
      while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
        set.add((int) (Math.pow(x, i) + Math.pow(y, j)));
        if (y == 1)
          break;
        j++;
      }
      j = 0;
      if (x == 1)
        break;
      i++;
    }
    res.addAll(set);
    return res;
  }
}
// @lc code=end
