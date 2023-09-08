#include <bits/stdc++.h>
using namespace std;
int f, dp[55], INF = 0x3f3f3f3f;
int main() {
  cin >> f;
  memset(dp, INF, sizeof(dp));
  dp[0] = 0, dp[1] = 1, dp[2] = 3;
  cout << 1 << endl << 3 << endl;
  for (int x = 3; x <= f; x++) {
    for (int k = 1; k < x; k++) {
      if (dp[x] > 2 * dp[x - k] + pow(2, k) - 1)
        dp[x] = 2 * dp[x - k] + pow(2, k) - 1;
    }
    cout << dp[x] << endl;
  }
  return 0;
}
