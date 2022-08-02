#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int selltob(string ss, int* left)
{
  int ans = 0;
  int temp[26];
  for (int i = 0; i < 26; i++)
    temp[i] = left[i];
  for (int i = 0; i < ss.size(); i++)
  {
    int p = ss[i] - 'a';
    if (temp[p] >= 1)
    {
      temp[p] -= 1;
      ans++;
    }
  }
  return ans*3;
}
void update(string ss, int *left)
{
  for (int i = 0; i < ss.size(); i++)
  {
    int p = ss[i] - 'a';
    if (left[p] >= 1)
      left[p] -= 1;
  }
}
int main()
{
  int n;
  cin >> n;
  string s[n];
  for (int i = 0; i < n; i++)
    cin >> s[i];
  int left0[26];
  int left1[26];
  for (int i = 0; i < 26; i++)
  {
    cin >> left0[i];
    left1[i] = left0[i];
  }
  int dp[n][2];
  memset(dp, 0, sizeof(dp));
  dp[0][0] = 10;
  dp[0][1] = selltob(s[0], left1);
  update(s[0], left1);
  for (int i = 1; i < n; i++)
  {
    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 10;
    if (dp[i - 1][0] + selltob(s[i], left0) >= dp[i - 1][1] + selltob(s[i], left1))
    {
      dp[i][1] = dp[i - 1][0] + selltob(s[i], left0);
      update(s[i], left0);
    }
    else
    {
      dp[i][1] = dp[i - 1][1] + selltob(s[i], left1);
      update(s[i], left1);
    }
  }
  for(int i = 0; i <n; i++)
    cout<<dp[i][0]<<" "<<dp[i][1]<<endl;
  cout << max(dp[n - 1][0], dp[n - 1][1]) << endl;
}