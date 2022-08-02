class Solution {
  public int minSwaps(int[] chess) {
    int n = 0;
    for (int i = 0; i < chess.length; i++)
      if (chess[i] == 1)
        n++;

    int t = chess.length - n + 1;
    int[] dp = new int[t];
    for (int i = 0; i < n; i++)
      if (chess[i] == 0)
        dp[0]++;
    int ans = dp[0];
    for (int i = 1; i < t; i++) {
      dp[i] = dp[i - 1] - chess[i + n - 1] + chess[i - 1];
      if (dp[i] < ans)
        ans = dp[i];
    }
    return ans;
  }
}