class Solution {
  public int minGroups(int[][] intervals) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
    int m = intervals.length;
    for (int[] interval : intervals) {
      int start = interval[0], end = interval[1];// 当前请求加入分组的区间的起始值
      if (pq.isEmpty())
        pq.offer(end);// 空分组时
      else {
        if (start <= pq.peek()) {// 不可加入已有的分组，直接以end新建分组
          pq.add(end);
        } else {// 可加入已有分组，加入其中并更新区间尾数end
          pq.poll();
          pq.offer(end);
        }
      }
    }
    return pq.size();
  }
}