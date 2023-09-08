/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null)
      return null;
    ListNode temp = head;
    int left = 1;
    while (temp.next != null) {
      temp = temp.next;
      left++;
    }
    if (left < k)
      return head;
    int num = 1;
    ListNode p, q;
    p = head;
    while (p.next != null && num < k) {
      q = p.next;
      p.next = q.next;
      q.next = head;
      head = q;
      num++;
    }
    p.next = reverseKGroup(p.next, k);
    return head;
  }
}
// @lc code=end
