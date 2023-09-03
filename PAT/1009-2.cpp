#include <bits/stdc++.h>
#define lowbit(x) ((x) & -(x))
using namespace std;
const int maxn =
    1e5 +
    10;  // invers[i]表示数组前面>arr[i]形成逆序对的数目,orders[i]表示后面<arr[i]形成逆序对的数目
int n, arr[maxn], tree[maxn], invers[maxn], orders[maxn];
long long ans = 0;
void insert(int i, int d) {
  while (i < maxn) {
    tree[i] += d;
    i += lowbit(i);
  }
}
int sum(int i) {
  int ans = 0;
  while (i) {
    ans += tree[i];
    i -= lowbit(i);
  }
  return ans;
}

int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &arr[i]);  // 所有值都不同
    insert(arr[i], 1);
    invers[i] = i + 1 - sum(arr[i]);  // 前面和arr[i]形成逆序对的数目
  }
  memset(tree, 0, sizeof(tree));
  for (int i = n - 1; i >= 0; --i) {
    insert(arr[i], 1);
    orders[i] =
        sum(arr[i] - 1);  // 后面<=arr[i]-1即<arr[i],和arr[i]形成逆序对的数目
  }
  for (int i = 1; i < n - 1; ++i)
    if (invers[i] && orders[i])
      ans += (long long)invers[i] * orders[i];
  printf("%lld\n", ans);
  return 0;
}
