/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 */

// @lc code=start
class Solution {
  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    int[] res = new int[n];
    Arrays.fill(res, -1);
    res[0] = 0;
    Map<Integer, List<Integer>> redMap = new HashMap<>();
    Map<Integer, List<Integer>> blueMap = new HashMap<>();
    for (int[] redEdge : redEdges) {
      redMap.computeIfAbsent(redEdge[0], k -> new ArrayList<>()).add(redEdge[1]);
    }
    for (int[] blueEdge : blueEdges) {
      blueMap.computeIfAbsent(blueEdge[0], k -> new ArrayList<>()).add(blueEdge[1]);
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { 0, 0 });
    queue.offer(new int[] { 0, 1 });
    int step = 0;
    Set<String> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      step++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        int node = cur[0];
        int color = cur[1];
        if (color == 0) {
          if (blueMap.containsKey(node)) {
            for (int next : blueMap.get(node)) {
              if (visited.add(next + "1")) {
                queue.offer(new int[] { next, 1 });
                if (res[next] == -1) {
                  res[next] = step;
                }
              }
            }
          }
        } else {
          if (redMap.containsKey(node)) {
            for (int next : redMap.get(node)) {
              if (visited.add(next + "0")) {
                queue.offer(new int[] { next, 0 });
                if (res[next] == -1) {
                  res[next] = step;
                }
              }
            }
          }
        }
      }
    }
    return res;
  }
}
// @lc code=end
