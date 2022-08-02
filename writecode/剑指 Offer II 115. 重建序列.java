import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
  public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
    int n = nums.length;
    int[] indegrees = new int[n + 1];
    Set<Integer>[] gragh = new Set[n + 1];
    for (int i = 1; i <= n; i++) {
      gragh[i] = new HashSet<Integer>();
    }
    for (int[] seq : sequences) {
      for (int i = 1; i < seq.length; i++) {
        int pre = seq[i - 1], next = seq[i];
        gragh[pre].add(next);
        indegrees[next]++;
      }
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (indegrees[i] == 0)
        q.add(i);
    }
    int pos = 0;
    while (!q.isEmpty()) {
      if (q.size() > 1)
        return false;
      int h = q.poll();
      if (h != nums[pos])
        return false;
      pos++;
      for (Integer i : gragh[h]) {
        indegrees[i]--;
        if (indegrees[i] == 0)
          q.add(i);
      }
    }
    return true;
  }

}