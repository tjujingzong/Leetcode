/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] Merge In Between Linked Lists
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
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    int i = 0;
    ListNode head1 = list1;
    while (i < a - 1) {
      head1 = head1.next;
      i++;
    }
    ListNode nodea = head1;
    while (i < b) {
      head1 = head1.next;
      i++;
    }
    ListNode nodeb = head1.next;
    nodea.next = list2;
    while (list2.next != null) {
      list2 = list2.next;
    }
    list2.next = nodeb;
    return list1;
  }
}
// @lc code=end
