#include <bits/stdc++.h>

using namespace std;

int main() {
  int m;
  cin >> m;
  int n = m / 2;
  long double res = 1;
  for (int i = 1; i <= n - 1; i++) {
    long long x = 2 * n - 1 - i;
    res = res * x / i;
  }
  for (int i = 0; i < 2 * n - 2; i++)
    res = res / 2;
  cout << fixed << setprecision(4) << 1 - res << endl;
  return 0;
}