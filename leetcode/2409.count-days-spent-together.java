/*
 * @lc app=leetcode.cn id=2409 lang=java
 *
 * [2409] Count Days Spent Together
 */

// @lc code=start
class Solution {
  int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

    int[] arriveA = Arrays.stream(arriveAlice.split("-")).mapToInt(Integer::parseInt).toArray();
    int[] leaveA = Arrays.stream(leaveAlice.split("-")).mapToInt(Integer::parseInt).toArray();
    int[] arriveB = Arrays.stream(arriveBob.split("-")).mapToInt(Integer::parseInt).toArray();
    int[] leaveB = Arrays.stream(leaveBob.split("-")).mapToInt(Integer::parseInt).toArray();
    int res = 0;

    int arriveAday = getday(arriveA);
    int leaveAday = getday(leaveA);
    int arriveBday = getday(arriveB);
    int leaveBday = getday(leaveB);
    if (arriveAday > leaveBday || arriveBday > leaveAday)
      return 0;
    int start = Math.max(arriveAday, arriveBday);
    int end = Math.min(leaveAday, leaveBday);
    return end - start + 1;
  }

  private int getday(int[] arriveA) {
    int res = 0;
    for (int i = 0; i < arriveA[0] - 1; i++) {
      res += days[i];
    }
    res += arriveA[1];
    return res;
  }
}
// @lc code=end
