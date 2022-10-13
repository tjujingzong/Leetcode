#include <bits/stdc++.h>

using namespace std;
int t, h;
int times[25];
int main()
{
  cin >> t;
  while (t--)
  {
    cin >> h;
    int hh[h];
    int p = 0;
    int maxlen = 0;
    for (int i = 0; i < h; i++)
      cin >> hh[i];
    int dp[h];
    memset(dp, 0, sizeof(h));
    memset(times, 0, sizeof(times));
    dp[0] = 1;
    times[0] = 1;
    for (int i = 1; i < h; i++)
    {
      dp[i] = 1;
      for (int j = 0; j < i; j++)
      {
        if (hh[i] >= hh[j])
          dp[i] = max(dp[j] + 1, dp[i]);
      }
      for (int j = 0; j < i; j++)
      {
        if (dp[i] == dp[j] + 1 && hh[i] >= hh[j])
          times[i] += times[j];
      }
      times[i] = max(1, times[i]);
    }
    for (int i = 0; i < h; i++)
      if (dp[i] > maxlen)
        maxlen = dp[i];
    for (int i = 0; i < h; i++)
      if (dp[i] == maxlen)
        p += times[i];

    cout << maxlen << " " << p << endl;
  }
  return 0;
}