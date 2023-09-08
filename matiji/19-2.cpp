#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  cin >> n;
  int stones[n];
  for (int i = 0; i < n; i++)
    cin >> stones[i];
  int cnt0 = 0, cnt1 = 0, cnt2 = 0;
  for (int val : stones)
  {
    if (int type = val % 3; type == 0)
    {
      ++cnt0;
    }
    else if (type == 1)
    {
      ++cnt1;
    }
    else
    {
      ++cnt2;
    }
  }
  if (cnt0 % 2 == 0)
  {
    cout << (cnt1 >= 1 && cnt2 >= 1);
  }
  else
  {
    int ans = (cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2);
    cout << ans;
  }
}