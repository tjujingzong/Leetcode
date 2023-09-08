/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] Reverse Linked List II
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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    // 设置 dummyNode 是这一类问题的一般做法
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode pre = dummyNode;
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next;
    ListNode next;
    for (int i = 0; i < right - left; i++) {
      next = cur.next;
      cur.next = next.next;
      next.next = pre.next;
      pre.next = next;
    }
    return dummyNode.next;
  }
}

// @lc code=end
