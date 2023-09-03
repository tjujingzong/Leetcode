#include <bits/stdc++.h>
using namespace std;
double a[1005], b[1005], c[2005];
int main() {
  int n;
  cin >> n;
  memset(a, 0, sizeof(a));
  memset(b, 0, sizeof(b));
  memset(c, 0, sizeof(c));
  for (int i = 0; i < n; i++) {
    int e;
    double c;
    cin >> e >> c;
    a[e] = c;
  };
  cin >> n;
  for (int i = 0; i < n; i++) {
    int e;
    double c;
    cin >> e >> c;
    b[e] = c;
  };
  int cnt = 0;
  for (int i = 0; i < 1005; i++) {
    for (int j = 0; j < 1005; j++) {
      c[i + j] += a[i] * b[j];
    }
  }
  for (int i = 0; i < 2005; i++) {
    if (c[i] != 0)
      cnt++;
  }
  cout << cnt;
  for (int i = 2004; i >= 0; i--) {
    if (c[i] != 0)
      printf(" %d %.1f", i, c[i]);
  }
}