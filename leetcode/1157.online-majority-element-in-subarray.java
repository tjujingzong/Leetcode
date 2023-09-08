import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1157 lang=java
 *
 * [1157] Online Majority Element In Subarray
 */

// @lc code=start
class MajorityChecker {

  HashMap<Integer, ArrayList<Integer>> pos;

  public MajorityChecker(int[] arr) {
    pos = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!pos.containsKey(arr[i])) {
        pos.put(arr[i], new ArrayList<>());
      }
      pos.get(arr[i]).add(i);
    }
  }

  public int query(int left, int right, int threshold) {
    for (Integer i : pos.keySet()) {
      if (pos.get(i).size() < threshold)
        continue;
      for (int j = 0; j < pos.get(i).size(); j++) {
        if (pos.get(i).get(j) >= left) {
          int count = 0;
          for (int k = j; k < pos.get(i).size(); k++) {
            if (pos.get(i).get(k) <= right) {
              count++;
            }
            if (count >= threshold)
              return i;
          }
          break;
        }
      }
    }
    return -1;
  }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
// @lc code=end
