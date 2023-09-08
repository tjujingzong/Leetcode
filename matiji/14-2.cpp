#include <bits/stdc++.h>

using namespace std;
int flag[100005];
int dp[100005];
int main()
{
  int n, k, b;
  cin >> n >> k >> b;
  memset(flag, 0, sizeof(flag));
  for (int i = 0; i < b; i++)
  {
    int p;
    cin >> p;
    flag[p] = 1;
  }
  for (int i = 1; i <= k; i++)
    dp[1] += flag[i];
  int ans = dp[1];
  for (int i = 2; i <= n - k + 1; i++)
  {
    dp[i] = dp[i - 1] + flag[i + k - 1] - flag[i - 1];
    if (dp[i] < ans)
      ans = dp[i];
  }
  cout << ans;
  return 0;
}