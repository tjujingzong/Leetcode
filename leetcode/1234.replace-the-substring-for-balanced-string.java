/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
  public int balancedString(String s) {
    int n = s.length();
    int[] count = new int[4];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'Q')
        count[0]++;
      else if (s.charAt(i) == 'W')
        count[1]++;
      else if (s.charAt(i) == 'E')
        count[2]++;
      else
        count[3]++;
    }
    int ans = n;
    int l = 0, r = 0;
    while (r < n) {
      if (count[0] <= n / 4 && count[1] <= n / 4 && count[2] <= n / 4 && count[3] <= n / 4) {
        ans = Math.min(ans, r - l);
        if (s.charAt(l) == 'Q')
          count[0]++;
        else if (s.charAt(l) == 'W')
          count[1]++;
        else if (s.charAt(l) == 'E')
          count[2]++;
        else
          count[3]++;
        l++;
      } else {
        if (s.charAt(r) == 'Q')
          count[0]--;
        else if (s.charAt(r) == 'W')
          count[1]--;
        else if (s.charAt(r) == 'E')
          count[2]--;
        else
          count[3]--;
        r++;
      }
    }
    while (l < n) {
      if (s.charAt(l) == 'Q')
        count[0]++;
      else if (s.charAt(l) == 'W')
        count[1]++;
      else if (s.charAt(l) == 'E')
        count[2]++;
      else
        count[3]++;
      l++;
      if (count[0] <= n / 4 && count[1] <= n / 4
          && count[2] <= n / 4 && count[3] <= n / 4) {
        ans = Math.min(ans, r - l);
      }
    }
    return ans;
  }
}
// @lc code=end
