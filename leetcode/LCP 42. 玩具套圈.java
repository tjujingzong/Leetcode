class Solution {
  public int circleGame(int[][] toys, int[][] circles, int r) {
    int cnt = 0;
    for (int i = 0; i < toys.length; i++) {
      if (toys[i][2] <= r) {
        for (int[] circle : circles) {
          long xDis = circle[0] - toys[i][0];
          long yDis = circle[1] - toys[i][1];
          int rDis = r - toys[i][2];
          if (xDis * xDis + yDis * yDis <= rDis * rDis) {
            cnt++;
            break;
          }
        }
      }
    }
    return cnt;
  }
}
