/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] Rotate List
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
  public ListNode rotateRight(ListNode head, int k) {
    int sz = 1;
    ListNode temp = head;
    if (head == null)
      return null;
    while (temp.next != null) {
      sz++;
      temp = temp.next;
    }
    ListNode last = temp;
    k %= sz;
    if (k == 0)
      return head;
    int count = 0;
    temp = head;
    while (temp != null) {
      if (count == sz - k - 1)
        break;
      count++;
      temp = temp.next;
    }
    ListNode newhead = temp.next;
    temp.next = null;
    last.next = head;
    return newhead;
  }
}
// @lc code=end
