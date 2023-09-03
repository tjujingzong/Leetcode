#include <bits/stdc++.h>
using namespace std;
double a[1005];
int main() {
  int t = 2;
  memset(a, 0, sizeof(a));
  while (t--) {
    int k;
    cin >> k;
    for (int i = 0; i < k; i++) {
      int n;
      double m;
      cin >> n >> m;
      a[n] += m;
    }
  }
  int cnt = 0;
  for (int i = 0; i < 1005; i++) {
    if (a[i] != 0)
      cnt++;
  }
  cout << cnt;
  for (int i = 1005; i >= 0; i--) {
    if (a[i] != 0)
      printf(" %d %.1f", i, a[i]);
  }
}