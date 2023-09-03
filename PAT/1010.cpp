#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000005;
int a[maxn], tree[maxn], ans[maxn];
int b[maxn];
int lowbit(int x) {
  return x & (-x);
}
void update(int x, int v) {
  for (int i = x; i <= maxn; i += lowbit(i)) {
    tree[i] += v;
  }
}
int query(int x) {
  int ans = 0;
  for (int i = x; i > 0; i -= lowbit(i)) {
    ans += tree[i];
  }
  return ans;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    b[i] = a[i];
  }
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; ++i) {
    a[i] = std::lower_bound(b + 1, b + n + 1, a[i]) - b;
  }
  for (int i = n; i >= 1; i--) {
    update(a[i], 1);
    ans[i] = query(a[i] - 1);
  }
  for (int i = 1; i <= n; i++) {
    printf("%d ", a[i]);
  }
  for (int i = 1; i < n; i++) {
    printf("%d ", ans[i]);
  }
  printf("%d\n", ans[n]);
  return 0;
}