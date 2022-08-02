import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> tri = new ArrayList<>();
    tri.add(triangle.get(0));
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> iList = triangle.get(i);
      List<Integer> llist = new ArrayList<>();
      List<Integer> lastList = tri.get(i - 1);
      for (int j = 0; j < iList.size(); j++) {
        if (j == 0)
          llist.add(iList.get(j) + lastList.get(j));
        else if (j == iList.size() - 1)
          llist.add(iList.get(j) + lastList.get(j - 1));
        else
          llist.add(Math.min(lastList.get(j), lastList.get(j - 1)) + iList.get(j));
      }
      tri.add(llist);
    }
    return Collections.min(tri.get(tri.size() - 1));
  }
}
// @lc code=end
