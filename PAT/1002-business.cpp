#include <bits/stdc++.h>
using namespace std;
struct Pro {
  int p, l, d;
};
int main() {
  int n;
  cin >> n;
  vector<Pro> pros(n + 1);
  for (int i = 1; i <= n; ++i) {
    cin >> pros[i].p >> pros[i].l >> pros[i].d;
    t = max(t, pros[i].d);
  }
  sort(pros.begin(), pros.end(),
       [](const Pro& p1, const Pro& p2) { return p1.d < p2.d; });
  int t = pros.back().d;
  vector<vector<int>> dp(n + 1, vector<int>(t + 1));
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= t; ++j) {
      dp[i][j] = dp[i - 1][j];
      int k = min(j, pros[i].d) - pros[i].l;
      if (k >= 0)
        dp[i][j] = max(dp[i][j], dp[i - 1][k] + pros[i].p);
    }
  }
  cout << dp[n][t];
  return 0;
}
