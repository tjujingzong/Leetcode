import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
  PriorityQueue<Integer> queMin;
  PriorityQueue<Integer> queMax;

  public MedianFinder() {
    queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
    queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
  }

  public void addNum(int num) {
    if (queMin.isEmpty() || num <= queMin.peek()) {
      queMin.offer(num);
      if (queMax.size() + 1 < queMin.size()) {
        queMax.offer(queMin.poll());
      }
    } else {
      queMax.offer(num);
      if (queMax.size() > queMin.size()) {
        queMin.offer(queMax.poll());
      }
    }
  }

  public double findMedian() {
    if (queMin.size() > queMax.size()) {
      return queMin.peek();
    }
    return (queMin.peek() + queMax.peek()) / 2.0;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
