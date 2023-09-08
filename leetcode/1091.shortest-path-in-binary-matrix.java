/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start

import java.util.Queue;

class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
      return -1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { 0, 0 });
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
        { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int pos = cur[0];
      int x = pos / n;
      int y = pos % n;
      int step = cur[1];
      if (x == n - 1 && y == n - 1)
        return step + 1;
      if (visited[x][y])
        continue;
      visited[x][y] = true;

      for (int[] dir : directions) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
          queue.add(new int[] { newX * n + newY, step + 1 });
        }
      }
    }
    return -1;
  }
}
// @lc code=end
