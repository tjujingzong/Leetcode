class Solution {
  public int deleteString(String s) {
    int n = s.length();
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = n - 2; i >= 0; i--) {
      for (int j = i; j <= (i + n - 2) / 2; j++) {
        if (1 + dp[j + 1] <= dp[i])
          continue;// 如果就算成功也比现在小，直接不对比
        if (s.substring(i, j + 1).equals(s.substring(j + 1, j + 2 + j - i))) {
          dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
          if (dp[i] == n - i)
            break;// 已经达到最大，趁早结束
        }
      }
    }
    return dp[0];
  }
}