/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
  int size;
  int front = 0;
  int rear = 0;
  int[] q;

  public MyCircularQueue(int k) {
    size = k + 1;
    q = new int[size];
  }

  public boolean enQueue(int value) {
    if (this.isFull())
      return false;
    q[rear] = value;
    rear = (rear + 1) % size;
    return true;
  }

  public boolean deQueue() {
    if (this.isEmpty())
      return false;
    front = (front + 1) % size;
    return true;
  }

  public int Front() {
    if (this.isEmpty())
      return -1;
    return q[front];
  }

  public int Rear() {
    if (this.isEmpty())
      return -1;
    return q[(rear - 1 + size) % size];
  }

  public boolean isEmpty() {
    if (rear == front)
      return true;
    return false;
  }

  public boolean isFull() {
    if ((rear + 1) % size == front)
      return true;
    return false;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

// @lc code=end
