import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=1210 lang=java
 *
 * [1210] Minimum Moves to Reach Target with Rotations
 */

// @lc code=start
class Solution {
  int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public class Node {
    int index;
    int dir;
    int step;

    public Node(int index, int dir, int step) {
      this.index = index;
      this.dir = dir;
      this.step = step;
    }
  }

  public int minimumMoves(int[][] grid) {
    int ans = -1;
    int n = grid.length;
    ArrayDeque<Node> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][n];
    queue.add(new Node(1, 0, 1));
    visited[0][1] = true;
    while (!queue.isEmpty()) {
      Node head = queue.poll();
      int index = head.index;
      int d = head.dir;
      int step = head.step;
      int x = index / n;
      int y = index % n;
      if (x == n - 1 && y == n - 1 && direction[d][0] == 0 && direction[d][1] == 1) {
        ans = step;
        break;
      }
      // move
      for (int i = 0; i < 4; i++) {
        int nx = x + direction[i][0];
        int ny = y + direction[i][1];
        int nd = i;
        int nindex = nx * n + ny;
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
          if (nd == d) {
            queue.add(new Node(nindex, nd, step + 1));
            visited[nx][ny] = true;
          } else {
            queue.add(new Node(nindex, nd, step + 1 + Math.abs(nd - d)));
            visited[nx][ny] = true;
          }
        }
      }
    }
    return ans;
  }
}

// @lc code=end
