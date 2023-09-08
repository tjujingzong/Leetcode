import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int minimumVisitedCells(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    pq.offer(new int[] { 0, 0, 0 });
    visited[0][0] = true;

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int i = curr[0];
      int j = curr[1];
      int steps = curr[2];

      if (i == m - 1 && j == n - 1) {
        return steps + 1;
      }

      // 向右移动
      for (int k = j + 1; k <= j + grid[i][j] && k < n; k++) {
        if (!visited[i][k]) {
          visited[i][k] = true;
          pq.offer(new int[] { i, k, steps + 1 });
        }
      }

      // 向下移动
      for (int k = i + 1; k <= i + grid[i][j] && k < m; k++) {
        if (!visited[k][j]) {
          visited[k][j] = true;
          pq.offer(new int[] { k, j, steps + 1 });
        }
      }
    }

    return -1;
  }
}
