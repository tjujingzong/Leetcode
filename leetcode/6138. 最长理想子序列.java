import java.util.Arrays;

class Solution {
  public int longestIdealString(String s, int k) {
    int n = s.length();
    int[] dp = new int[26];
    int ans = 1;
    dp[s.charAt(0) - 'a'] = 1;
    for (int i = 1; i < n; i++) {
      char c = s.charAt(i);
      int idx = c - 'a';
      for (int j = 0; j <= k; j++) {
        if (idx - j >= 0) {
          dp[idx] = Math.max(dp[idx - j], dp[idx]);
        }
        if (idx + j <= 25) {
          dp[idx] = Math.max(dp[idx + j], dp[idx]);
        }
      }
      dp[idx]++;
      if (ans < dp[c - 'a'])
        ans = dp[c - 'a'];
    }
    return ans;
  }
}