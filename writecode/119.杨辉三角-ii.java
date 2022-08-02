import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
  public List<Integer> getRow(int rowIndex) {
    int numRows = rowIndex+1;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    ans.add(l1);
    List<Integer> l2 = new ArrayList<>();
    l2.add(1);
    l2.add(1);
    ans.add(l2);
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
    return ans.get(rowIndex);
  }
}

// @lc code=end
