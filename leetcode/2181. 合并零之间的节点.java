import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode mergeNodes(ListNode head) {
    ArrayList<Integer> list=new ArrayList<Integer>();
    int sum=0;
    while(head.next!=null){
      ListNode tNode=head.next;
      if(tNode.val==0){
        list.add(sum);
        sum=0;
      }
      else{
        sum+=tNode.val;
      }
      head=head.next;
    }
    ListNode lNode= new ListNode(list.get(list.size()-1), null);
    for(int i=list.size()-1;i>=0;i--){
      ListNode nListNode=new ListNode(list.get(i), lNode);
      lNode=nListNode;
    }
    head=lNode;
    return head;
  }
}