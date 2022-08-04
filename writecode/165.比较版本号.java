/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int n = Math.max(v1.length, v2.length);
    int[] num1 = new int[n];
    int[] num2 = new int[n];
    for (int i = 0; i < n; i++) {
      if (i < v1.length)
        num1[i] = Integer.parseInt(v1[i]);
      if (i < v2.length)
        num2[i] = Integer.parseInt(v2[i]);
    }
    for (int i = 0; i < n; i++)
      if (num1[i] > num2[i])
        return 1;
      else if (num1[i] < num2[i])
        return -1;
    return 0;
  }
}
// @lc code=end
