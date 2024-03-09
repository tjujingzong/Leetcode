#include <bits/stdc++.h>

using namespace std;

int main() {
  int n, m;
  cin >> n >> m;
  int a[n];
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  if (sum < m) {
    cout << 0 << endl;
    return 0;
  }
  int ans = n;
  int t = 0;
  int l = 0, r = 0;
  while (r < n) {
    t += a[r];
    while (t >= m) {
      ans = min(ans, r - l + 1);
      t -= a[l];
      l++;
    }
    r++;
  }
  cout << ans << endl;
  return 0;
}