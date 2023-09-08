import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start
class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    // 将boxTypes按照每个箱子的密度从大到小排序
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
    int ans = 0;
    int i = 0;
    int n = boxTypes.length;
    while (i < n && truckSize > 0) {
      int[] box = boxTypes[i];
      int num = box[0];
      int unit = box[1];
      if (num <= truckSize) {
        ans += num * unit;
        truckSize -= num;
      } else {
        ans += truckSize * unit;
        truckSize = 0;
      }
      i++;
    }
    return ans;
  }
}
// @lc code=end
