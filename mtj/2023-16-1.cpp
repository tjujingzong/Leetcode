#include <bits/stdc++.h>

using namespace std;

int main() {
  int n;
  cin >> n;
  vector<long long> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  long long ans = 0;
  for (int i = 1; i < n; i++) {
    if (v[i - 1] >= 0)
      v[i] += v[i - 1];
    ans = max(ans, v[i]);
  }
  printf("%lld\n", ans);
  return 0;
}