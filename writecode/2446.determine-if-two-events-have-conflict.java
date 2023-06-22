/*
 * @lc app=leetcode.cn id=2446 lang=java
 *
 * [2446] Determine if Two Events Have Conflict
 */

// @lc code=start
class Solution {
  public boolean haveConflict(String[] event1, String[] event2) {
    int[] times1 = new int[2];
    for (int i = 0; i < event1.length; i++) {
      String s1 = event1[i];
      String[] time1 = s1.split(":");
      times1[i] = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
    }
    int[] times2 = new int[2];
    for (int i = 0; i < event2.length; i++) {
      String s2 = event2[i];
      String[] time2 = s2.split(":");
      times2[i] = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
    }
    if (times2[0] >= times1[0] && times2[0] <= times1[1]) {
      return true;
    }
    if (times2[1] >= times1[0] && times2[1] <= times1[1]) {
      return true;
    }
    if (times1[0] >= times2[0] && times1[0] <= times2[1]) {
      return true;
    }
    if (times1[1] >= times2[0] && times1[1] <= times2[1]) {
      return true;
    }
    return false;
  }
}
// @lc code=end
