import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1780 lang=java
 *
 * [1780] Check if Number is a Sum of Powers of Three
 */

// @lc code=start
class Solution {
  public boolean checkPowersOfThree(int n) {
    HashSet<Integer> set = new HashSet<>();
    int i = 0;
    while (Math.pow(3, i) <= n) {
      set.add((int) Math.pow(3, i));
      i++;
    }
    // set转为数组
    int[] arr = set.stream().mapToInt(Integer::valueOf).toArray();
    // 判断n是否可以由set中的数相加得到，每个rr数只用一次
    boolean[] flag = new boolean[arr.length];
    HashSet<Integer> set2 = new HashSet<>();
    set2.add(n);
    return check(n, arr, flag, set2);

  }

  boolean check(int n, int[] arr, boolean[] flag, HashSet<Integer> set2) {
    if (n == 0)
      return true;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (n - arr[i] >= 0 && !flag[i] && !set2.contains(n - arr[i])) {
        flag[i] = true;
        set2.add(n - arr[i]);
        if (check(n - arr[i], arr, flag, set2))
          return true;
        flag[i] = false;
      }
    }
    return false;
  }

}
// @lc code=end
