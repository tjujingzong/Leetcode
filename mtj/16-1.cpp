#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  cin >> n;
  double ans = 5.0 * n;
  int p;
  for (int x = 0; x <= n; x++)
  {
    double t = (5 + 0.5 * x) * (n - x);
    if (t > ans)
    {
      ans = t;
      p = x;
    }
  }
  printf("%.2f ", 5.00 + p / 2.0);
  printf("%.2f", 100.00 + n - p);
  return 0;
}
