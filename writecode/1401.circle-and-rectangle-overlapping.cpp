/*
 * @lc app=leetcode.cn id=1401 lang=cpp
 *
 * [1401] Circle and Rectangle Overlapping
 */

// @lc code=start
class Solution {
 public:
  bool checkOverlap(int radius,
                    int xCenter,
                    int yCenter,
                    int x1,
                    int y1,
                    int x2,
                    int y2) {
    // 寻找正方形上距离圆心最近的点
    int dx = xCenter < x1 ? x1 - xCenter : xCenter > x2 ? xCenter - x2 : 0;
    int dy = yCenter < y1 ? y1 - yCenter : yCenter > y2 ? yCenter - y2 : 0;
    return dx * dx + dy * dy <= radius * radius;
  }
};
// @lc code=end
