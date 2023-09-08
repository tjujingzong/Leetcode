#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
const int N = 1e5 + 10;
int n, m;
double a[N], sum[N], l, r;
int check(double mid)
{
  double minn = 0;
  for (int i = 1; i <= n; i++)
    sum[i] = sum[i - 1] + a[i] - mid;
  for (int i = m; i <= n; i++)
  { // 假设第:
    minn = min(minn, sum[i - m]);
    if (sum[i] >= minn)
      return 1;
  }
  return 0;
}
int main()
{
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
  {
    cin >> a[i];
    r = max(r, a[i]);
  }
  while (r - l >= eps)
  {
    double mid = (l + r) / 2;
    if (check(mid))
      l = mid;
    else
      r = mid;
  }
  cout << (int)(r * 1000) << endl;
  return 0;
}