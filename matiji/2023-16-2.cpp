#include <bits/stdc++.h>
using namespace std;
const int n = 1005;
int cost[n][n];
int dp[n];
int main() {
  int t;
  cin >> t;
  memset(cost, 0x3f, sizeof(cost));
  for (int i = 1; i <= t + 2; i++) {
    for (int j = i + 1; j <= t + 2; j++) {
      cin >> cost[i][j];
    }
    dp[i] = 0x3f3f3f3f;
  }
  dp[1] = 0;
  dp[2] = cost[1][2];
  for (int i = 3; i <= t + 2; i++) {
    for (int j = 1; j < i; j++) {
      dp[i] = min(dp[i], dp[j] + cost[j][i]);
    }
  }
  cout << dp[t + 2] << endl;
}