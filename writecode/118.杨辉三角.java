import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    ans.add(l1);
    if (numRows == 1)
      return ans;
    List<Integer> l2 = new ArrayList<>();
    l2.add(1);
    l2.add(1);
    ans.add(l2);
    if (numRows == 2)
      return ans;
    for (int i = 2; i < numRows; i++) {
      List<Integer> nList = new ArrayList<>();
      List<Integer> llist = ans.get(i - 1);
      nList.add(1);
      for (int j = 0; j < llist.size() - 1; j++) {
        nList.add(llist.get(j) + llist.get(j + 1));
      }
      nList.add(1);
      ans.add(nList);
    }
    return ans;
  }
}
// @lc code=end
