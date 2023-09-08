/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] Design Linked List
 */

class MyLinkedList {
  int size;
  ListNode head;

  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }
    ListNode cur = head;
    for (int i = 0; i <= index; i++) {
      cur = cur.next;
    }
    return cur.val;
  }

  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  public void addAtIndex(int index, int val) {
    if (index > size) {
      return;
    }
    index = Math.max(0, index);
    size++;
    ListNode pred = head;
    for (int i = 0; i < index; i++) {
      pred = pred.next;
    }
    ListNode toAdd = new ListNode(val);
    toAdd.next = pred.next;
    pred.next = toAdd;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    size--;
    ListNode pred = head;
    for (int i = 0; i < index; i++) {
      pred = pred.next;
    }
    pred.next = pred.next.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
