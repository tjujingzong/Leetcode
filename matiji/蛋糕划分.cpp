
#include <bits/stdc++.h>

using namespace std;
int n, k;
int a[20][20], b[20];
int check(int x) {
  for (int i = 0; i < 1 << n; i += 2) {
    memset(b, 0, sizeof b);
    int cur = __builtin_popcount(i);
    for (int j = 0; j < n; j++) {
    gototag:;
      if (cur > k)
        break;
      for (int k = 0, p = 0; k < n; k++) {
        if ((i >> k) & 1)
          p++;
        if ((b[p] += a[j][k]) > x) {
          memset(b, 0, sizeof b);
          cur++;
          goto gototag;
        }
      }
    }
    if (cur <= k)
      return 1;
  }
  return 0;
}

int main() {
  scanf("%d%d", &n, &k);
  int L = 0, R = 1e6, ans = 1e6;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      scanf("%d", &a[i][j]);
  while (L <= R) {
    int mid = L + R >> 1;
    if (check(mid))
      ans = mid, R = mid - 1;
    else
      L = mid + 1;
  }
  printf("%d", ans);
  return 0;
}
