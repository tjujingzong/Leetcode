import java.util.PriorityQueue;

class Solution {
  public int fillCups(int[] amount) {
    PriorityQueue<Integer> q = new PriorityQueue<>(((o1, o2) -> o2-o1));
    for (int i = 0; i < 3; i++) {
      q.add(amount[i]);
    }
    int ans = 0;
    while (true) {
      int max1 = q.poll();
      int max2 = q.poll();
      if (max2 == 0) {
        ans += max1;
        break;
      }
      q.add(max1 - 1);
      q.add(max2 - 1);
      ans++;
    }
    return ans;
  }
}