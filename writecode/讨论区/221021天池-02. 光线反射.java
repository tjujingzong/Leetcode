class Solution {
  int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public int getLength(String[] grid) {
    int n = grid.length;
    int m = grid[0].length();
    int ans = 0;
    int i = 0, j = 0;
    int d = 1;
    char last = 'Z';
    int lastd = 1;
    while (true) {
      ans++;
      if (grid[i].charAt(j) == 'R' && last == 'Z') {
        lastd = d;
        d = (d + 1) % 4;
        last = grid[i].charAt(j);
      } else if (grid[i].charAt(j) == 'L' && last == 'Z') {
        lastd = d;
        d = (d + 3) % 4;
        last = grid[i].charAt(j);
      } else if (last != 'Z' && grid[i].charAt(j) != '.') {
        if (grid[i].charAt(j) != last)
          d = (lastd + 2) % 4;
        else
          d = lastd;
        last = 'Z';
      }
      i += dir[d][0];
      j += dir[d][1];
      if (i < 0 || i >= n || j < 0 || j >= m)
        break;
    }
    return ans;
  }
}