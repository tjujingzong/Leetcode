import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] Special Positions in a Binary Matrix
 */

// @lc code=start
class Solution {
  public int numSpecial(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    HashSet<Integer> rset = new HashSet<Integer>();
    HashSet<Integer> cset = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < m; j++) {
        sum += mat[i][j];
      }
      if (sum == 1)
        rset.add(i);
    }
    for (int j = 0; j < m; j++) {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += mat[i][j];
      }
      if (sum == 1)
        cset.add(j);
    }
    int ans = 0;
    for (int r : rset)
      for (int c : cset)
        if (mat[r][c] == 1)
          ans++;
    return ans;
  }
}
// @lc code=end
