/*
 * @lc app=leetcode.cn id=1819 lang=java
 *
 * [1819] Number of Different Subsequences GCDs
 */

// @lc code=start
class Solution {
  public int countDifferentSubsequenceGCDs(int[] nums) {
    // 获得nums的最大值
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    // 标记数组
    boolean[] flag = new boolean[max + 1];
    for (int num : nums) {
      flag[num] = true;
    }
    int ans = 0;
    for (int i = 1; i <= max; i++) {
      int g = 0;
      for (int j = i; j <= max; j += i) {
        if (flag[j]) {
          g = gcd(g, j);
        }
      }
      if (g == i)
        ans++;
    }
    return ans;
  }  

  int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
// @lc code=end
