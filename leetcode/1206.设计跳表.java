import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1206 lang=java
 *
 * [1206] 设计跳表
 */

// @lc code=start
class Skiplist {
  List<Integer> aList;

  public Skiplist() {
    aList = new LinkedList<>();
  }

  public boolean search(int target) {
    return aList.contains(target);
  }

  public void add(int num) {
    aList.add(num);
  }

  public boolean erase(int num) {
    if (aList.contains(num)) {
      aList.remove((Object) num);
      return true;
    }
    return false;
  }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
// @lc code=end
