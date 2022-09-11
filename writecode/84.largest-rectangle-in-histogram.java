/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
  public int largestRectangleArea(int[] heights) {
    // 定义数组长度
    int len = heights.length;
    int ret = 0;
    // 定义left数组：表示高度为heights[i]的左边界
    int[] left = new int[len];
    // 定义right数组：表示高度为heights[i]的右边届
    int[] right = new int[len];
    // 默认高度为heights[i]的右边届为len
    Arrays.fill(right, len);
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < len; i++) {
      // 栈中存储的是升序排序的小元素，所以最后出栈的
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        right[stack.pop()] = i;
      }
      // 默认左边界是-1，能够省很多判断操作
      left[i] = stack.isEmpty() ? -1 : stack.peek();
      // 把i入栈，此时栈中是升序排序的比heights[i]小的元素以及i
      stack.push(i);
    }
    // 遍历所有高度的左右节点
    for (int i = 0; i < len; i++) {
      ret = Math.max(ret, heights[i] * (right[i] - left[i] - 1));
    }
    return ret;
  }
}
// @lc code=end
