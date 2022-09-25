/*
 * @lc app=leetcode.cn id=850 lang=java
 *
 * [850] Rectangle Area II
 */

// @lc code=start
class Solution {
  int MOD = (int) 1e9 + 7;

  public int rectangleArea(int[][] rs) {
    List<Integer> list = new ArrayList<>();
    for (int[] info : rs) {
      list.add(info[0]);
      list.add(info[2]);
    }
    Collections.sort(list);
    long ans = 0;
    for (int i = 1; i < list.size(); i++) {
      int a = list.get(i - 1), b = list.get(i), len = b - a;
      if (len == 0)
        continue;
      List<int[]> lines = new ArrayList<>();
      for (int[] info : rs) {
        if (info[0] <= a && b <= info[2])
          lines.add(new int[] { info[1], info[3] });
      }
      Collections.sort(lines, (l1, l2) -> {
        return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
      });
      long tot = 0, l = -1, r = -1;
      for (int[] cur : lines) {
        if (cur[0] > r) {
          tot += r - l;
          l = cur[0];
          r = cur[1];
        } else if (cur[1] > r) {
          r = cur[1];
        }
      }
      tot += r - l;
      ans += tot * len;
      ans %= MOD;
    }
    return (int) ans;
  }
}
// @lc code=end
