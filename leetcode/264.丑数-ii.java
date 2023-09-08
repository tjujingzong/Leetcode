import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
  public int nthUglyNumber(int n) {
      int[] factors = {2, 3, 5};
      Set<Long> seen = new HashSet<Long>();
      PriorityQueue<Long> heap = new PriorityQueue<Long>();
      seen.add(1L);
      heap.offer(1L);
      int ugly = 0;
      for (int i = 0; i < n; i++) {
          long curr = heap.poll();
          ugly = (int) curr;
          for (int factor : factors) {
              long next = curr * factor;
              if (seen.add(next)) {
                  heap.offer(next);
              }
          }
      }
      return ugly;
  }
}
// @lc code=end
