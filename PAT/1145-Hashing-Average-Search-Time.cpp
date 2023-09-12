#include <bits/stdc++.h>
using namespace std;
bool isprime(int x) {
  if (x <= 1)
    return false;
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0)
      return false;
  }
  return true;
}
int getlarger(int x) {
  for (int i = x + 1;; i++) {
    if (isprime(i))
      return i;
  }
  return 0;
}

int a[100005];
int main() {
  int sz;
  cin >> sz;
  sz = isprime(sz) ? sz : getlarger(sz);
  memset(a, 0, sizeof(a));
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    bool ins = false;
    for (int j = 0; j < sz; j++) {
      if (a[(t + j * j) % sz] == 0) {
        ins = true;
        a[(t + j * j) % sz] = t;
        break;
      }
    }
    if (!ins) {
      cout << t << " cannot be inserted." << endl;
    }
  }
  int len = 0;
  for (int i = 0; i < m; i++) {
    int t;
    cin >> t;
    int j = 0;
    for (; j < sz; j++) {
      if (a[(t + j * j) % sz] == t || a[(t + j * j) % sz] == 0) {
        break;
      }
    }
    len += (j + 1);
  }
  double ans = (double)len / m;
  printf("%.1f", ans);
}