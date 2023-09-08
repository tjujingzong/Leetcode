#include <bits/stdc++.h>

using namespace std;

int main()
{
  string s;
  cin >> s;
  int n = s.size();
  int dp[n];
  int stack[n];
  int top = 0;
  memset(dp, 0, sizeof(dp));
  memset(stack, 0, sizeof(stack));
  int ans = 0;
  for (int i = 0; i < n; i++)
  {
    if (s[i] == '(')
    {
      stack[++top] = i;
    }
    else if (top != 0)
    {
      int pos = stack[top--];
      if (pos != 0)
        dp[i] = dp[pos - 1] + 1;
      else
        dp[i] = 1;
    }
    ans += dp[i];
  }
  cout << ans;
  return 0;
}