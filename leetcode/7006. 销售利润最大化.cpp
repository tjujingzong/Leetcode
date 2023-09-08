class Solution {
 public:
  int maximizeTheProfit(int n, vector<vector<int>>& offers) {
    sort(offers.begin(), offers.end(),
         [](const vector<int>& a, const vector<int>& b) {
           return a[1] < b[1];  // Sort by end position in ascending order
         });
    int j = 0;
    vector<int> dp(n + 1);
    for (int i = 0; i <= n; ++i) {
      if (i > 0)
        dp[i] = dp[i - 1];
      for (; j < offers.size(); ++j) {
        int start = offers[j][0];
        int end = offers[j][1];
        int gold = offers[j][2];
        if (i >= end) {
          if (start > 0)
            dp[i] = max(dp[i], dp[start - 1] + gold);
          else
            dp[i] = max(dp[i], gold);
        } else
          break;
      }
    }
    return dp[n];
  }
};
