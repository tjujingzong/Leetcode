/*
 * @lc app=leetcode.cn id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 */

// @lc code=start
class Solution {
  public int minHeightShelves(int[][] books, int shelfWidth) {
    int n = books.length;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 1000000);
    dp[0] = 0;
    for (int i = 0; i < n; ++i) {
      int maxHeight = 0, curWidth = 0;
      for (int j = i; j >= 0; --j) {
        curWidth += books[j][0];
        if (curWidth > shelfWidth) {
          break;
        }
        maxHeight = Math.max(maxHeight, books[j][1]);
        dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
      }
    }
    return dp[n];
  }
}
// @lc code=end
