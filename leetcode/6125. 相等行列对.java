class Solution {
  public int equalPairs(int[][] grid) {
    int ans = 0;
    int n = grid.length;
    for (int i = 0; i < n; i++) {
      int[] r = grid[i];
      for (int j = 0; j < n; j++) {
        int k;
        for (k = 0; k < n; k++) {
          if (r[k] != grid[k][j])
            break;
        }
        if (k == n)
          ans++;
      }
    }
    return ans;
  }
}