import java.util.ArrayList;
import java.util.HashSet;

class Solution {
  public int maximumDetonation(int[][] bombs) {
    int ans = 1;
    ArrayList<Integer> left = new ArrayList<>();
    for (int i = 0; i < bombs.length; i++)
      left.add(i);
    for (int k = 0; k < bombs.length; k++) {
      int tans = 1;
      ArrayList<Integer> boomed = new ArrayList<>();
      boomed.add(k);
      ArrayList<Integer> left2 = new ArrayList<>();
      left2.addAll(left);
      left2.remove(k);
      while (!boomed.isEmpty()) {
        int nowbomb = boomed.get(0);
        boomed.remove(0);
        ArrayList<Integer> lefttemp = new ArrayList<>();// list队列模拟，广度优先搜索
        lefttemp.addAll(left2);
        for (int i = 0; i < lefttemp.size(); i++) {
          int nextbomb = lefttemp.get(i);
          int x1 = bombs[nowbomb][0];
          int x2 = bombs[nextbomb][0];
          int y1 = bombs[nowbomb][1];
          int y2 = bombs[nextbomb][1];
          long dist1 = Math.abs(x1 - x2);// 这里需要用long ，部分样例会使int溢出
          long dist2 = Math.abs(y1 - y2);
          if (dist1 * dist1 + dist2 * dist2 <= (long) bombs[nowbomb][2] * bombs[nowbomb][2]) {
            boomed.add(nextbomb);
            left2.remove((Object) nextbomb);
            tans++;
          }
        }
      }
      if (tans > ans)
        ans = tans;
    }
    return ans;
  }
}