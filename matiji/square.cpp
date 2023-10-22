#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
int ans[110];
int cnt[N];
int b[110];
void multi(int x) {
  memcpy(b, ans, sizeof b);
  memset(ans, 0, sizeof ans);
  int j = 0;
  while (x) {
    int z = x % 10;
    x /= 10;
    for (int i = 1; i <= 100; i++) {
      if (i + j <= 100)
        ans[i + j] += z * b[i];
    }
    j++;
  }
  for (int i = 1; i <= 100; i++) {
    ans[i + 1] += ans[i] / 10;
    ans[i] %= 10;
  }
}
int main() {
  int m, n;
  cin >> m >> n;
  if (m > n)
    swap(m, n);
  for (int i = 0; i < m; i++) {
    int x = m + n - i;
    for (int j = 2; j <= x / j; j++) {
      while (x % j == 0) {
        x /= j;
        cnt[j]++;
      }
    }
    if (x != 1)
      cnt[x]++;
  }
  for (int i = 1; i <= m; i++) {
    int x = i;
    for (int j = 2; j <= x / j; j++) {
      while (x % j == 0) {
        x /= j;
        cnt[j]--;
      }
    }
    if (x != 1)
      cnt[x]--;
  }
  ans[1] = 1;
  for (int i = 1; i < N; i++) {
    while (cnt[i]) {
      multi(i);
      cnt[i]--;
    }
  }
  for (int i = 100; i >= 1; i--) {
    cout << ans[i];
    if (i % 10 == 1)
      cout << endl;
  }
  return 0;
}
