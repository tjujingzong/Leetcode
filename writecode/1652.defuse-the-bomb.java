/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] Defuse the Bomb
 */

// @lc code=start
class Solution {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int[] dup = new int[n * 3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < n; j++) {
        dup[i * n + j] = code[j];
      }
    }
    if (k == 0)
      return new int[n];
    int[] ans = new int[n];
    if (k > 0) {
      int sum = 0;
      for (int i = n + 1; i <= n + k; i++)
        sum += dup[i];
      for (int j = 0; j < n; j++) {
        ans[j] = sum;
        sum -= dup[n + 1 + j];
        sum += dup[n + k + 1 + j];
      }
      return ans;
    }
    int sum = 0;
    for (int i = n + k; i <= n - 1; i++)
      sum += dup[i];
    for (int j = 0; j < n; j++) {
      ans[j] = sum;
      sum -= dup[n + k + j];
      sum += dup[n + j];
    }
    return ans;
  }
}
// @lc code=end
