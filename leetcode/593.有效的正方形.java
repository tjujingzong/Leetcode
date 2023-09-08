import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    TreeSet<Long> side = new TreeSet<Long>();
    side.add(dis(p1, p2));
    side.add(dis(p1, p3));
    side.add(dis(p1, p4));
    side.add(dis(p3, p2));
    side.add(dis(p4, p2));
    side.add(dis(p3, p4));
    if (side.size() != 2)
      return false;
    if (side.last().equals(side.first() * 2))
      return true;
    return false;
  }

  public Long dis(int[] p1, int[] p2) {
    return ((long) p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
  }
}
// @lc code=end
