/*
 * @lc app=leetcode.cn id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
  class p {
    int id;
    int count;
  }

  public int[] rearrangeBarcodes(int[] barcodes) {
    int[] res = new int[barcodes.length];
    int[] count = new int[10001];
    for (int i = 0; i < barcodes.length; i++) {
      count[barcodes[i]]++;
    }
    PriorityQueue<p> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) {
        p temp = new p();
        temp.id = i;
        temp.count = count[i];
        pq.add(temp);
      }
    }
    int index = 0;
    while (!pq.isEmpty()) {
      p temp = pq.poll();
      if (index == 0 || res[index - 1] != temp.id) {
        res[index] = temp.id;
        temp.count--;
        index++;
      } else {
        p temp2 = pq.poll();
        res[index] = temp2.id;
        temp2.count--;
        index++;
        if (temp2.count != 0) {
          pq.add(temp2);
        }
      }
      if (temp.count != 0) {
        pq.add(temp);
      }
    }
    return res;
  }
}
// @lc code=end
