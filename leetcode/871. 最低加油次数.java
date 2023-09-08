import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (stations.length == 0) {
      if (startFuel >= target)
        return 0;
      else
        return -1;
    }
    int ns = stations.length;
    int[] flag = new int[ns];
    ArrayList<Integer> st = new ArrayList<>();// 存放当前能获得的油
    int nowpos = startFuel;
    int ans = 0;
    addst(flag, nowpos, st, stations);
    while (nowpos < target && !st.isEmpty()) {
      int top = st.get(0);
      st.remove(0);
      ans++;
      nowpos += top;
      addst(flag, nowpos, st, stations);
    }
    return nowpos >= target ? ans : -1;
  }

  public void addst(int[] flag, int pos, ArrayList<Integer> st, int[][] stations) {
    for (int i = 0; i < stations.length; i++) {
      if (stations[i][0] > pos)
        break;
      else if (flag[i] == 0) {
        st.add(stations[i][1]);
        flag[i] = 1;
      }
    }
    Collections.sort(st);
    Collections.reverse(st);
  }
}