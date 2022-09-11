#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n, t;
  cin >> n >> t;
  long long int a[n + 1];
  long long int presum[n + 1];
  for (int i = 1; i <= n; i++)
  {
    cin >> a[i];
  }
  while (t--)
  {
    int l, r;
    cin >> l >> r;
    long long int ans = 0;
    long long int = a[l];
    for (int i = l; i <= r; i++)
    {
      if (a[i] > maxnum)
        maxnum = a[i];
      ans += a[i] * maxnum;
    }
    cout << ans << endl;
  }

  return 0;
}