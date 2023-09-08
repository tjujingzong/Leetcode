/*
 * @lc app=leetcode.cn id=1140 lang=java
 *
 * [1140] Stone Game II
 */

// @lc code=start
class Solution {
  public int stoneGameII(int[] piles) {
      int[] prefixSum = new int[piles.length + 1];
      for (int i = 0; i < piles.length; i++) {
          prefixSum[i + 1] = prefixSum[i] + piles[i];
      }

      Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
      return (prefixSum[piles.length] + dp(memo, piles, prefixSum, 0, 1)) / 2;
  }

  public int dp(Map<Integer, Integer> memo, int[] piles, int[] prefixSum, int i, int m) {
      if (i == piles.length) {
          return 0;
      }
      int key = i * 201 + m;
      if (!memo.containsKey(key)) {
          int maxVal = Integer.MIN_VALUE;
          for (int x = 1; x <= 2 * m; x++) {
              if (i + x > piles.length) {
                  break;
              }
              maxVal = Math.max(maxVal, prefixSum[i + x] - prefixSum[i] - dp(memo, piles, prefixSum, i + x, Math.max(m, x)));
          }
          memo.put(key, maxVal);
      }
      return memo.get(key);
  }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/stone-game-ii/solutions/2125131/shi-zi-you-xi-ii-by-leetcode-solution-3pwv/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// @lc code=end

