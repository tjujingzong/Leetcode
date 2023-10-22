#include <bits/stdc++.h>

using namespace std;

int main() {
  long long n, m;
  cin >> n >> m;
  long long ma = 0, mi = 0;
  long long t = n - (m - 1);
  ma = t * (t - 1) / 2;
  t = n / m;
  long long tt = n % m;
  mi = t * (t - 1) / 2 * (m - tt);
  mi += t * (t + 1) / 2 * tt;
  cout << mi << ' ' << ma << endl;
  return 0;
}