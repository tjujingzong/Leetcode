import java.util.ArrayList;

class Solution {
  class point {
    int x;
    int y;

    public point(int i, int j) {
      x = i;
      y = j;
    }
  }

  public int buildTransferStation(int[][] area) {
    int m = area.length;
    int n = area[0].length;
    ArrayList<point> list = new ArrayList<>();
    int sumx = 0;
    int sumy = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (area[i][j] == 1) {
          list.add(new point(i, j));
          sumx += i;
          sumy += j;
        }
      }
    }
    int num = list.size();
    int fx = sumx / num;
    int fy = sumy / num;
    int dis1 = sumx;
    for (int i = -4; i <= 4; i++) {
      int tx = fx + i;
      int tdis1 = 0;
      for (point p : list) {
        tdis1 += Math.abs(p.x - tx);
      }
      if (tdis1 < dis1)
        dis1 = tdis1;
    }
    int dis2 = sumy;
    for (int i = -4; i <= 4; i++) {
      int ty = fy + i;
      int tdis2 = 0;
      for (point p : list) {
        tdis2 += Math.abs(p.y - ty);
      }
      if (tdis2 < dis2)
        dis2 = tdis2;
    }
    return dis1 + dis2;
  }
}