/*
 * @lc app=leetcode.cn id=1630 lang=java
 *
 * [1630] Arithmetic Subarrays
 */

// @lc code=start
class Solution {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int n = l.length;
    List<Boolean> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int left = l[i];
      int right = r[i];
      int[] temp = new int[right - left + 1];
      for (int j = left; j <= right; j++) {
        temp[j - left] = nums[j];
      }
      Arrays.sort(temp);
      int diff = temp[1] - temp[0];
      boolean flag = true;
      for (int j = 2; j < temp.length; j++) {
        if (temp[j] - temp[j - 1] != diff) {
          flag = false;
          break;
        }
      }
      res.add(flag);
    }
    return res;
  }
}
// @lc code=end
