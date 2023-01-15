
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static class Node {
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 在此输入您的代码...
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[][] time = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        time[i][j] = scan.nextInt();
      }
    }
    // 从0，0开始染色，染色时间为time[i][j],染色方向为上下左右
    // 从0，0开始 宽度优先遍历
    int maxtime = 0;
    boolean[][] visited = new boolean[n][m];
    int[][] coloredtime = new int[n][m];

    visited[0][0] = true;
    PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
    queue.add(new Node(0, 0, time[0][0]));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int x = node.x;
      int y = node.y;
      int t = node.time;
      if (x - 1 >= 0 && !visited[x - 1][y]) {
        queue.add(new Node(x - 1, y, t + time[x - 1][y]));
        visited[x - 1][y] = true;

      }
      if (x + 1 < n && !visited[x + 1][y]) {
        queue.add(new Node(x + 1, y, t + time[x + 1][y]));
        visited[x + 1][y] = true;

      }
      if (y - 1 >= 0 && !visited[x][y - 1]) {
        queue.add(new Node(x, y - 1, t + time[x][y - 1]));
        visited[x][y - 1] = true;

      }
      if (y + 1 < m && !visited[x][y + 1]) {
        queue.add(new Node(x, y + 1, t + time[x][y + 1]));
        visited[x][y + 1] = true;

      }
      maxtime = Math.max(maxtime, t);
    }
    System.out.println(maxtime);
  }

}
