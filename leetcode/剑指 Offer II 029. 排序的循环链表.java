import javafx.scene.Node;

// Definition for a Node.
class Node {
  public int val;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _next) {
    val = _val;
    next = _next;
  }
};

class Solution {
  public Node insert(Node head, int insertVal) {
    if (head == null) {
      Node head2 = new Node(insertVal);
      head2.next = head2;
      return head2;
    }
    if (head.next.equals(head)) {
      Node newnode = new Node(insertVal, head);
      head.next = newnode;
      return head;
    }
    Node temp = head;
    while (!temp.next.equals(head)) {
      Node tempnext = temp.next;
      if (tempnext.val >= insertVal && temp.val <= insertVal || tempnext.val < temp.val && temp.val < insertVal
          || tempnext.val < temp.val && tempnext.val > insertVal) {
        Node newnode = new Node(insertVal, tempnext);
        temp.next = newnode;
        return head;
      }
      temp = tempnext;
    }
    Node newnode = new Node(insertVal, head);
    temp.next = newnode;
    return head;
  }
}