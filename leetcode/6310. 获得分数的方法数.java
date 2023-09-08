// 这道题可以用动态规划来解决。具体来说，我们定义 dp(i, j) 表示使用前 i 种题目恰好获得 j 分的方案数。我们考虑最后一次使用第 k 种题目，那么我们可以将 dp(i, j) 转移至 dp(i, j - k * marks[k])，其中 k * marks[k] ≤ j，且 k ≤ count[k]。

// 注意到状态转移只和上一层有关，因此我们可以使用滚动数组将空间复杂度优化到 O(target)。

// 最后，答案即为 dp(n, target)。时间复杂度为 O(n * target * sum(count))，其中 sum(count) 表示 types 中 counti 的总和。
class Solution {
  public int waysToReachTarget(int target, int[][] types) {
    int mod = 1000000007;
    int n = types.length;
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      int count = types[i - 1][0];
      int mark = types[i - 1][1];
      for (int j = 0; j <= target; j++) {
        dp[i][j] = dp[i - 1][j];
        for (int k = 1; k <= count; k++) {
          if (j >= k * mark) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k * mark]) % mod;
          } else {
            break;
          }
        }
      }
    }

    return dp[n][target];
  }
}
