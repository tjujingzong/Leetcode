import java.util.LinkedList;
import java.util.Queue;

class Solution {

  int m, n;
  int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

  public int flipChess(String[] chessboard) {
    this.m = chessboard.length;
    this.n = chessboard[0].length();
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (chessboard[i].charAt(j) == '.') {
          char[][] clone = copy(chessboard);
          res = Math.max(res, flipOnlyOneChess(clone, i, j));
        }
      }
    }
    return res;
  }

  private char[][] copy(String[] chessboard) {
    char[][] cs = new char[m][n];
    for (int i = 0; i < m; i++) {
      cs[i] = chessboard[i].toCharArray();
    }
    return cs;
  }

  public int flipOnlyOneChess(char[][] clone, int x0, int y0) {
    int max = Math.max(m, n), ans = 0;
    // 原节点置黑
    clone[x0][y0] = 'X';
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { x0, y0 });
    while (!queue.isEmpty()) {
      int[] p = queue.poll();
      // 遍历8个方向
      for (int[] d : dir) {
        int x = p[0] + d[0], y = p[1] + d[1];
        if (!isValid(x, y, m, n) || clone[x][y] == '.')
          continue;
        int len = 0;
        for (int i = 0; i < max; i++) {
          // 顺着这个方向继续找黑色棋子
          int nx = x + d[0] * i, ny = y + d[1] * i;
          if (!isValid(nx, ny, m, n))
            continue;
          char c = clone[nx][ny];
          // 若该方向上有空白棋子，则直接中断退出
          if (c == '.') {
            break;
            // 找到则将黑色路径的长度更新
          } else if (c == 'X')
            len = i + 1;
        }
        for (int i = 0; i < len; i++) {
          int nx = x + d[0] * i, ny = y + d[1] * i;
          if (!isValid(nx, ny, m, n))
            continue;
          char c = clone[nx][ny];
          // 如果路径上有白色棋子，则计数并加入队列
          if (c == 'O') {
            ans++;
            queue.add(new int[] { nx, ny });
            clone[nx][ny] = 'X';
          }
        }
      }
    }
    return ans;
  }

  private boolean isValid(int x, int y, int m, int n) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }

}
