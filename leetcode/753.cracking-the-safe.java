import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=753 lang=java
 *
 * [753] Cracking the Safe
 */

// @lc code=start
class Solution {
  Set<Integer> seen = new HashSet<Integer>();
  StringBuffer ans = new StringBuffer();
  int highest;
  int k;

  public String crackSafe(int n, int k) {
      highest = (int) Math.pow(10, n - 1);
      this.k = k;
      dfs(0);
      for (int i = 1; i < n; i++) {
          ans.append('0');
      }
      return ans.toString();
  }

  public void dfs(int node) {
      for (int x = 0; x < k; ++x) {
          int nei = node * 10 + x;
          if (!seen.contains(nei)) {
              seen.add(nei);
              dfs(nei % highest);
              ans.append(x);
          }
      }
  }
}
// @lc code=end

