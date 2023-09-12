class Solution {
 public:
  int numberOfWays(string s, string t, long long k) {
    unordered_map<string, int> cnt;
    int n = s.size();
    for (int i = 1; i < n; i++) {
      string s1 = s.substr(i) + s.substr(0, i);
      cnt[s1]++;
    }

    vector<vector<int>> dp(n + 1, vector<int>(n + 1, n));
    z dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[0][i] = i;
      dp[i][0] = i;
      for (int j = 1; j <= n; j++) {
        if (s[i - 1] == t[j - 1]) {
          dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1] + 1);
        } else {
          dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
        }
      }
    }
    unordered_map<string, int> memo;
    return backtrack(dp, n, n, k, memo);
  }

  int backtrack(vector<vector<int>>& dp,
                int i,
                int j,
                int k,
                unordered_map<string, int>& memo) {
    if (k < 0)
      return 0;
    if (i == 0 && j == 0)
      return k == 0 ? 1 : 0;
    string key = to_string(i) + "," + to_string(j);
    if (memo.count(key))
      return memo[key];
    int res = 0;
    if (dp[i - 1][j] == dp[i][j]) {
      res += backtrack(dp, i - 1, j, k, memo);
    }
    if (dp[i - 1][j - 1] + 1 == dp[i][j]) {
      res += backtrack(dp, i - 1, j - 1, k - 1, memo);
    }
    memo[key] = res;
    return res;
  }
};
