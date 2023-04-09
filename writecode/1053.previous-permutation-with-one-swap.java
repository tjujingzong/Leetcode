/*
 * @lc app=leetcode.cn id=1053 lang=java
 *
 * [1053] Previous Permutation With One Swap
 */

// @lc code=start
class Solution {
  public int[] prevPermOpt1(int[] arr) {
    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] > arr[i + 1]) {
        int max = i + 1;
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[j] < arr[i] && arr[j] > arr[max]) {
            max = j;
          }
        }
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
        return arr;
      }
    }
    return arr;
  }
}
// @lc code=end
