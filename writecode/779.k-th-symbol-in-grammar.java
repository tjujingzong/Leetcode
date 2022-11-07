/*
 * @lc app=leetcode.cn id=779 lang=java
 *
 * [779] K-th Symbol in Grammar
 */

// @lc code=start
class Solution {

  public int kthGrammar(int n, int k) {
    if (n == 1)
      return 0;
    if (n == 2) {
      if (k == 1)
        return 0;
      else
        return 1;
    }
    int n2 = 1 << (n - 2);
    if (k <= n2)
      return kthGrammar(n2, k);
    return (kthGrammar(n2, k - n2) + 1) % 2;
  }

}
// @lc code=end
