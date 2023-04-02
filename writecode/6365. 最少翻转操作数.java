import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeSet;

class Solution {
  public int[] minReverseOperations(int n, int p, int[] banned, int k) {
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    ans[p] = 0;
    boolean[] ban = new boolean[n];
    for (int b : banned) {
      ban[b] = true;
    }
    ban[p] = true;
    TreeSet<Integer> oddRemain = new TreeSet<>(), evenRemain = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      if (!ban[i]) {
        (i % 2 == 0 ? evenRemain : oddRemain).add(i);
      }
    }
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(p);
    while (!queue.isEmpty()) {
      int i = queue.pop();
      // Start and end in [0, n - 1]
      int start = i - k + 1 >= 0 ? i - k + 1 : k - 1 - i;
      int end = i + k - 1 < n ? i + k - 1 : 2 * n - 1 - i - k;
      TreeSet<Integer> curSet = start % 2 == 0 ? evenRemain : oddRemain;
      Integer next = curSet.ceiling(start);
      while (next != null && next <= end) {
        curSet.remove(next);
        ans[next] = ans[i] + 1;
        queue.offer(next);
        next = curSet.ceiling(start);
      }
    }
    return ans;
  }
}
