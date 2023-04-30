import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1172 lang=java
 *
 * [1172] Dinner Plate Stacks
 */

// @lc code=start
class DinnerPlates {
  int capacity;
  TreeSet<Integer> treeSet;
  ArrayList<Stack<Integer>> stacks;

  public DinnerPlates(int capacity) {
    stacks = new ArrayList<>();
    treeSet = new TreeSet<>();
    treeSet.add(0);
    stacks.add(new Stack<>());
    this.capacity = capacity;
  }

  public void push(int val) {
    if (treeSet.isEmpty()) {
      Stack<Integer> stk = new Stack<>();
      stk.push(val);
      stacks.add(stk);
      if (stk.size() < capacity)
        treeSet.add(stacks.size() - 1);
    } else {
      int index = treeSet.first();
      if (stacks.size() == index) {
        Stack<Integer> stk = new Stack<>();
        stacks.add(stk);
      }
      stacks.get(index).push(val);
      if (stacks.get(index).size() == capacity) {
        treeSet.remove(index);
      }
    }
  }

  public int pop() {
    if (stacks.isEmpty())
      return -1;
    int index = stacks.size() - 1;
    while (index >= 0 && stacks.get(index).isEmpty()) {
      stacks.remove(index);
      index--;
    }
    if (index < 0)
      return -1;
    int val = stacks.get(index).pop();
    if (stacks.get(index).isEmpty()) {
      stacks.remove(index);
    }
    treeSet.add(index);
    return val;
  }

  public int popAtStack(int index) {
    if (index >= stacks.size() || stacks.get(index).isEmpty())
      return -1;
    int val = stacks.get(index).pop();
    treeSet.add(index);
    return val;
  }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
// @lc code=end
