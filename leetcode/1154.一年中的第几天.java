import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */

// @lc code=start
class Solution {
  public int dayOfYear(String date) {
    String[] s = date.split("-");
    int[] d = new int[13];
    Arrays.fill(d, 30);
    d[1] = 31;
    d[2] = 28;
    d[3] = 31;
    d[5] = 31;
    d[7] = 31;
    d[8] = 31;
    d[10] = 31;
    d[12] = 31;
    if (isrun(s[0]))
      d[2] = 29;
    int ans = 0;
    for (int i = 1; i < Integer.parseInt(s[1]); i++)
      ans += d[i];
    ans += Integer.parseInt(s[2]);
    return ans;
  }

  private boolean isrun(String string) {
    int year = Integer.parseInt(string);
    if (year % 4 == 0 && year != 1900)
      return true;
    return false;
  }
}
// @lc code=end
