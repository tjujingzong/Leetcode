import java.util.Arrays;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode.cn id=2335 lang=java
 *
 * [2335] Minimum Amount of Time to Fill Cups
 */

// @lc code=start
class Solution {
  public int fillCups(int[] amount) {
    Arrays.sort(amount);
    if (amount[2] > amount[0] + amount[1]) {
      return amount[2];
    } else {
      return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
  }
}
// @lc code=end
