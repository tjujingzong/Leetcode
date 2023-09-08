/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    int front;
    int rear;
    int []q;
    int len;
    public MyCircularDeque(int k) {
      len=k;
      q=new int[4*k];
      front=k+1;
      rear=k+2;
    }
    
    public boolean insertFront(int value) {
      if(this.isFull()) return false;
      q[front]=value;
      front--;
      return true;
    }
    
    public boolean insertLast(int value) {
      if(this.isFull()) return false;
      q[rear]=value;
      rear++;
      return true;
    }
    
    public boolean deleteFront() {
      if(this.isEmpty()) return false;
      front++;
      return true;
    }
    
    public boolean deleteLast() {
      if(this.isEmpty()) return false;
      rear--;
      return true;
    }
    
    public int getFront() {
      if(this.isEmpty()) return -1;
      return q[front+1];
    }
    
    public int getRear() {
      if(this.isEmpty()) return -1;
      return q[rear-1];
    }
    
    public boolean isEmpty() {
      return rear-1==front;
    }
    
    public boolean isFull() {
      return rear-len==front+1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

