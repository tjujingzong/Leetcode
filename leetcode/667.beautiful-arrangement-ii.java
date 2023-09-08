import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] Beautiful Arrangement II
 */

// @lc code=start
class Solution {
  public int[] constructArray(int n, int k) {
    int[] ans = new int[n];
    TreeSet<Integer> set = new TreeSet<Integer>();
    for (int i = 0; i < n; i++)
      set.add(i + 1);
    int nums = k / 2;
    for (int i = 0; i < nums; i++) {
      ans[2 * i] = i + 1;
      ans[2 * i + 1] = 2 + k - i - 1;
      set.remove(ans[2 * i]);
      set.remove(ans[2 * i + 1]);
    }
    int j = 2 * nums;
    for (int i : set)
      ans[j++] = i;
    return ans;
  }
}
// @lc code=end
