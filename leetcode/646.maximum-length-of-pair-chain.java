import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

/*
 * 贪心比动态规划更好用
 */
// @lc code=start
class Solution {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (z1, z2) -> z1[1] - z2[1]);
    int ans = 1;
    int last = pairs[0][1];
    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i][0] > last) {
        ans++;
        last = pairs[i][1];
      }
    }
    return ans;
  }
}
// @lc code=end
