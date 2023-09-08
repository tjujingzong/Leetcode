import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int[] nextLargerNodes(ListNode head) {
    ArrayList list = new ArrayList();
    ListNode temp = head;
    while (temp != null) {
      list.add(temp.val);
      temp = temp.next;
    }
    int[] res = new int[list.size()];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < list.size(); i++) {
      if (stack.empty())
        stack.push(i);
      else {
        while (!stack.empty() && (int) list.get(stack.peek()) < (int) list.get(i)) {
          res[stack.pop()] = (int) list.get(i);
        }
        stack.push(i);
      }
    }
    return res;
  }
}
// @lc code=end
