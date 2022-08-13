import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start

// public class ListNode {
//   int val;
//   ListNode next;

//   ListNode() {
//   }

//   ListNode(int val) {
//     this.val = val;
//   }

//   ListNode(int val, ListNode next) {
//     this.val = val;
//     this.next = next;
//   }
// }

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null)
        continue;
      q.add(lists[i]);
    }
    ListNode head = q.poll();
    if (head == null)
      return null;
    if (head.next != null)
      q.add(head.next);
    ListNode last = head;
    while (!q.isEmpty()) {
      ListNode next = q.poll();
      last.next = next;
      last = next;
      if (last.next != null)
        q.add(last.next);
    }
    return head;
  }
}
// @lc code=end
