#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int N = 1e6 + 10;
#define ll long long
ll n, t, a[N], sum[N], ans;
ll q[N];
void merge_sort(int l, int r, ll *a)
{
  if (l >= r)

    return;
  int mid = l + r >> 1;
  merge_sort(l, mid, a), merge_sort(mid + 1, r, a);
  int i = l, j = mid + 1, t = 0;
  while (i <= mid && j <= r)
  {
    if (a[i] <= a[j])
    {
      q[t++] = a[j++];
      ans += mid - i + 1; // 降序排列，求非逆序数ans %= MOD;
      ans %= MOD;
    }
    else
      q[t++] = a[i++];
  }
  while (i <= mid)
    q[t++] = a[i++];
  while (j <= r)
    q[t++] = a[j++];
  for (i = l, j = 0; i <= r; i++, j++)
    a[i] = q[j];
}
int main()
{
  cin >> n >> t;
  for (int i = 1; i <= n; i++)
  {
    cin >> a[i];
    a[i] -= t;
    sum[i] = sum[i - 1] + a[i];
  }
  merge_sort(0, n, sum);
  cout << ans % MOD;
  return 0;
}
