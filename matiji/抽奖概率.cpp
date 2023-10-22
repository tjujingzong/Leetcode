#include <bits/stdc++.h>

using namespace std;

int main() {
  int m;
  cin >> m;
  double ans = 0.5;
  double tmp = 0.5 * 0.5;
  for (int i = 2; i <= m; i++) {
    ans += tmp / (double)i;
    tmp *= 0.5;
  }
  printf("%.6lf\n", ans);
  return 0;
}