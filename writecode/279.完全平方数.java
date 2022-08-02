import java.util.Arrays;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);
    TreeSet<Integer> set = new TreeSet<Integer>();
    for (int i = 1; i <= n; i++) {
      if (i * i > n)
        break;
      dp[i * i] = 1;
      set.add(i * i);
    }
    for (int i = 2; i <= n; i++) {
      for (Integer j : set) {
        if (i >= j)
          dp[i] = Math.min(dp[i], dp[i - j] + 1);
      }
    }
    return dp[n];
  }
}
// @lc code=end
