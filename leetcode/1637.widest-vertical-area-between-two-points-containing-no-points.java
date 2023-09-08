import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1637 lang=java
 *
 * [1637] Widest Vertical Area Between Two Points Containing No Points
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
      Arrays.sort(points, (a, b) -> a[0] - b[0]);
      int ans = 0;
      for (int i = 1; i < points.length; ++i) {
        ans = Math.max(ans, points[i][0] - points[i - 1][0]);
      }
      return ans;
    }
}
// @lc code=end

