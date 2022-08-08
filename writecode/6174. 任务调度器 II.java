import java.util.HashMap;

class Solution {
  public long taskSchedulerII(int[] tasks, int space) {
    HashMap<Integer, Long> nexttime = new HashMap<>();
    for (int i = 0; i < tasks.length; ++i)
      nexttime.put(tasks[i], (long) -1);
    long ans = 0;
    for (int i = 0; i < tasks.length; ++i) {
      if (ans >= nexttime.get(tasks[i])) {
        ans++;
        nexttime.put(tasks[i], ans + space);
      } else {
        ans = nexttime.get(tasks[i]);
        i--;
      }
    }
    return ans;
  }
}