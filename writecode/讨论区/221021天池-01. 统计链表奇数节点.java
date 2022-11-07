import java.util.List;

class Solution {
  public int numberEvenListNode(ListNode head) {
    ListNode t = head;
    int ans = 0;
    while (t != null) {
      if (t.val % 2 == 1)
        ans++;
      t = t.next;
    }
    return ans;
  }
}