import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
  int n, m;
  int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public int shortestBridge(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    ok: for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 2;
          turnto2(i, j, grid);
          break ok;
        }
      }
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          q.add(i * m + j);
          map.put(i * m + j, 0);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        System.out.printf("%d ", grid[i][j]);
      System.out.printf("\n");
    }

    while (!q.isEmpty()) {
      int top = q.poll();
      int ti = top / m;
      int tj = top % m;
      if (grid[ti][tj] == 1)
        return map.get(top) - 1;
      for (int k = 0; k < 4; k++) {
        if (ti + dir[k][0] < n && ti + dir[k][0] >= 0 && tj + dir[k][1] < m &&
            tj + dir[k][1] >= 0 && !map.containsKey((ti + dir[k][0]) * m + tj + dir[k][1])) {
          q.add((ti + dir[k][0]) * m + tj + dir[k][1]);
          map.put((ti + dir[k][0]) * m + tj + dir[k][1], map.get(top) + 1);
        }
      }
    }
    return 0;
  }

  private void turnto2(int i, int j, int[][] grid) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(i * m + j);
    while (!q.isEmpty()) {
      int top = q.poll();
      int ti = top / m;
      int tj = top % m;
      for (int k = 0; k < 4; k++) {
        if (ti + dir[k][0] < n && ti + dir[k][0] >= 0 && tj + dir[k][1] < m &&
            tj + dir[k][1] >= 0 && grid[ti + dir[k][0]][tj + dir[k][1]] == 1) {
          grid[ti + dir[k][0]][tj + dir[k][1]] = 2;
          q.add((ti + dir[k][0]) * m + tj + dir[k][1]);
        }
      }
    }
  }
}
// @lc code=end
