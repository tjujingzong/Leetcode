#include <bits/stdc++.h>

using namespace std;
struct node {
  int p, v;
};

int main() {
  int n;
  cin >> n;
  node a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i].p >> a[i].v;
  }
  sort(a, a + n, [](node a, node b) {
    if (a.p == b.p)
      return a.v < b.v;
    return a.p < b.p;
  });
  for (int i = 0; i < n - 1; i++) {
    if (a[i].p == a[i + 1].p) {
      a[i + 1].v = a[i].v;
    }
  }
  int ans = -1, cnt = 1, inde = n - 1;
  while (1) {
    if (inde - cnt == -1)
      break;
    if (a[inde].v < a[inde - cnt].v ||
        (a[inde].v == a[inde - cnt].v && a[inde].p == a[inde - cnt].p))
      cnt++;
    else {
      inde -= cnt;
      cnt = 1;
    }
    ans = max(ans, cnt);
  }
  cout << ans << endl;
  return 0;
}