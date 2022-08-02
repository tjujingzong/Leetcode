/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    p[] ps = new p[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ps[i] = new p(1, false);
      for (int j = 0; j < i; j++) {
        if (nums[i] == nums[j])
          continue;
        if (ps[j].length == 1) {
          ps[i].length = 2;
          if (nums[i] < nums[j])
            ps[i].needlarger = true;
          else
            ps[i].needlarger = false;
        } else {
          if (nums[i] < nums[j] && !ps[j].needlarger && ps[j].length + 1 > ps[i].length) {
            ps[i].needlarger = true;
            ps[i].length = ps[j].length + 1;
          }
          if (nums[i] > nums[j] && ps[j].needlarger && ps[j].length + 1 > ps[i].length) {
            ps[i].needlarger = false;
            ps[i].length = ps[j].length + 1;
          }
        }
      }
      if (ans < ps[i].length)
        ans = ps[i].length;
    }
    return ans;
  }

  class p {
    int length;
    boolean needlarger;

    public p(int i, boolean b) {
      length = i;
      needlarger = b;
    }
  }
}
// @lc code=end
