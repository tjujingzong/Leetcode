import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
  int num;
  List<List<String>> ans = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    num = n;
    boolean[] visited = new boolean[num];
    for (int i = 0; i < num; i++) {
      ArrayList<Integer> al = new ArrayList<>();
      al.add(i);
      visited[i] = true;
      dfs(i, visited, al);
      visited[i] = false;
    }
    return ans;
  }

  private void dfs(int pos, boolean[] visited, ArrayList<Integer> al) {
    if (al.size() == num) {
      List<String> sList = new ArrayList<String>();
      String grid = "";
      for (int i = 0; i < num; i++)
        grid += '.';
      for (int q : al) {
        StringBuilder sb = new StringBuilder(grid);
        sb.replace(q, q + 1, "Q");
        sList.add(sb.toString());
      }
      ans.add(sList);
    }
    for (int i = 0; i < num; i++) {
      if (visited[i])
        continue;
      if (Math.abs(pos - i) > 1) {
        boolean flag = false;
        for (int j = 0; j < al.size(); j++) {
          if (al.size() - j == Math.abs(i - al.get(j)))
            flag = true;
        }
        if (flag)
          continue;
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.addAll(al);
        newlist.add(i);
        visited[i] = true;
        dfs(i, visited, newlist);
        visited[i] = false;

      }
    }
  }
}
// @lc code=end
