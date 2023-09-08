#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n, w;
  cin >> n >> w;
  double m[n], v[n];
  double p[n];
  for (int i = 0; i < n; i++)
  {
    cin >> m[i] >> v[i];
    p[i] = v[i] / m[i];
  }
  for (int i = 0; i < n - 1; i++)
    for (int j = i + 1; j < n; j++)
    {
      if (p[i] > p[j])
      {
        swap(p[i], p[j]);
        swap(m[i], m[j]);
        swap(v[i], v[j]);
      }
    }
  double ans = 0;
  double left = w;
  for (int i = 0; i < n; i++)
  {
    ans += p[i] * min(m[i], left);
    left -= min(m[i], left);
  }
  printf("%.3f\n", ans);
  return 0;
}