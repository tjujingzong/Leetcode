class Solution {
  public int hardestWorker(int n, int[][] logs) {
    int ans = logs[0][0];
    int longesttime = logs[0][1];
    for (int i = 1; i < logs.length; i++) {
      int t = logs[i][1] - logs[i - 1][1];
      if (t > longesttime) {
        ans = logs[i][0];
        longesttime = t;
      }
      if (t == longesttime)
        ans = Math.min(ans, logs[i][0]);
    }
    return ans;
  }
}