import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] Sort Array by Increasing Frequency
 */

// @lc code=start
class Solution {
  public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    for (int num : nums) {
      cnt.put(num, cnt.getOrDefault(num, 0) + 1);
    }
    List<Integer> list = new ArrayList<Integer>();
    for (int num : nums) {
      list.add(num);
    }
    Collections.sort(list, (a, b) -> {
      int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
      return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
    });
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      nums[i] = list.get(i);
    }
    return nums;
  }
}
// @lc code=end
