/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
  int cnt = 0;
  int kth;
  String ans;

  public String getPermutation(int n, int k) {
    kth = k;
    boolean[] visited = new boolean[n];
    dfs(0, visited, "");
    return ans;
  }

  private void dfs(int num, boolean[] visited, String string) {
    if (cnt > kth)
      return;
    if (num == visited.length) {
      cnt++;
      if (cnt == kth)
        ans = string;
    }
    for (int i = 0; i < visited.length; i++) {
      if (visited[i])
        continue;
      else {
        visited[i] = true;
        dfs(num + 1, visited, string + String.valueOf(i + 1));
        visited[i] = false;
      }
    }
  }
}
// @lc code=end
