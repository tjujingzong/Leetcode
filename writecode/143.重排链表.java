import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
  public void reorderList(ListNode head) {
    ArrayList<ListNode> l = new ArrayList<ListNode>();
    ListNode head2 = new ListNode();
    head2 = head;
    while (head2 != null) {
      l.add(head2);
      head2 = head2.next;
    }
    if (l.size() <= 2)
      return;
    int n = l.size();
    int i = 0, j = 0;
    while (i + j < n) {
      if ((i + j) % 2 == 0) {
        l.get(i).next = i + j == n - 1 ? null : l.get(n - 1 - j);
        i++;
      } else {
        l.get(n - 1 - j).next = i + j == n - 1 ? null : l.get(i);
        j++;
      }
    }
  }
}
// @lc code=end
