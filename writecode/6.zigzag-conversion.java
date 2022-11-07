/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    int n = s.length();
    char[][] grid = new char[numRows][n];
    int t = 0;
    int cnt = 0;
    int x = 0;
    int y = 0;
    StringBuffer sb = new StringBuffer();
    while (cnt < n) {
      grid[x][y] = s.charAt(cnt);
      if (t % 2 == 0) {
        x++;
      } else {
        x--;
        y++;
      }
      if (x == numRows - 1 || x == 0)
        t++;
      cnt++;
    }
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < n; j++)
        if (grid[i][j] != 0)
          sb.append(grid[i][j]);
    }
    return sb.toString();
  }
}
// @lc code=end
