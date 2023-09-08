import java.util.PriorityQueue;



/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
  public class Node {
    int val;
    int index;
    Node(int val, int index) {
      this.val = val;
      this.index = index;
    }
  }
  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.val - a.val);
    int[] ans = new int[nums.length - k + 1];
    for (int i = 0; i < k; i++) {
      queue.add(new Node(nums[i], i));
    }
    ans[0] = queue.peek().val;
    for (int i = k; i < nums.length; i++) {
      queue.add(new Node(nums[i], i));
      while (queue.peek().index <= i - k) {
        queue.poll();
      }
      ans[i - k + 1] = queue.peek().val;
    }
    return ans;
  }
}
// @lc code=end
