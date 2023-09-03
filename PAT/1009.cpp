#include <bits/stdc++.h>
using namespace std;
int a[100005], cnt[100005];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  memset(cnt, 0, sizeof(cnt));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
      if (a[j] > a[i])
        cnt[i]++;
    }
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j < i; j++) {
      if (a[j] > a[i])
        ans += cnt[j];
    }
  }
  printf("%d\n", ans);
}