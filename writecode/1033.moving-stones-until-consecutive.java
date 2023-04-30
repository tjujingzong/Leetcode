/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] Moving Stones Until Consecutive
 */

// @lc code=start
class Solution {
  public int[] numMovesStones(int a, int b, int c) {
    int[] arr = new int[] { a, b, c };
    Arrays.sort(arr);
    int min = 2;
    int max = 0;
    if (arr[2] - arr[0] == 2)
      min = 0;
    else if (arr[1] - arr[0] <= 2 || arr[2] - arr[1] <= 2)
      min = 1;
    max = arr[2] - arr[0] - 2;
    return new int[] { min, max };

  }
}
// @lc code=end
