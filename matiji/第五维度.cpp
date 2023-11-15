#include <bits/stdc++.h>

using namespace std;
int n, m;
long long l, r, mid, s[100005], v[100805];
bool check(long long t) {
  long long sum = 0, max_v = 0, cur_v;
  for (int i = 1; i <= n; i++) {
    cur_v = max(0ll, t - s[i]) * v[i];
    sum += cur_v;
    max_v = max(max_v, cur_v);
  }
  return sum - max_v > m;
}
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
    cin >> s[i] >> v[i];
  l = 0;
  r = 5e9;
  while (l < r) {
    mid = (l + r) / 2;
    if (check(mid))
      r = mid;
    else
      l = mid + 1;
  }
  if (check(l))
    cout << l << endl;
  else
    cout << -1 << endl;
  return 0;
}