import java.util.PriorityQueue;

class Solution {
  public int lastMaterial(int[] material) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    for (int i = 0; i < material.length; i++) {
      queue.add(material[i]);
    }
    while (queue.size() > 1) {
      int top1 = queue.poll();
      int top2 = queue.poll();
      queue.add(top1 - top2);
    }
    return queue.poll();
  }
}