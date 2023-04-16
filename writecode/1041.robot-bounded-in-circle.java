/*
 * @lc app=leetcode.cn id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
  public boolean isRobotBounded(String instructions) {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int x = 0, y = 0, idx = 0; // Change initial idx value to 0 (North)

    for (char c : instructions.toCharArray()) {
      if (c == 'L') {
        idx = (idx + 3) % 4;
      } else if (c == 'R') {
        idx = (idx + 1) % 4;
      } else if (c == 'G') {
        x += directions[idx][0];
        y += directions[idx][1];
      }
    }

    return (x == 0 && y == 0) || idx != 0;
  }
}

// @lc code=end
