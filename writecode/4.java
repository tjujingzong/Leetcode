class Solution {
  public int countSpecialNumbers(int num) {
    int[] dp = new int[9];
    dp[0] = 1;
    dp[1] = 10;
    for (int i = 2; i <= 8; i++) {
      dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
    }
    int t = num;
    int n = 0;
    int ans = 0;
    int[] bits = new int[10];
    while (t > 0) {
      t /= 10;
      n++;
    }
    for (int i = n - 1; i >= 0; i--) {
      bits[i] = num % 10;
      num /= 10;
    }
    for (int i = 0; i < n; i++) {
      int now = bits[i] - 1;
      if (now == -1)
        now = 9;
      if (now == 0)
        now = 1;
      ans += now * dp[n - i - 1];
    }
    return ans;
  }
}