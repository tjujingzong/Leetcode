#include <bits/stdc++.h>
#define sc scanf
#define pr printf
#define ll long long
using namespace std;
const int maxn = 40000 + 100;
int cnt[maxn];
void solve()
{
  int a, b, q;
  sc("%d%d%d", &a, &b, &q);
  int n = a * b;
  for (int i = 1; i <= n; i++)
  {
    cnt[i] = cnt[i - 1];
    if ((i % a % b) != (i % b % a))
      cnt[i]++;
  }
  while (q--)
  {
    ll l, r;
    sc("%lld%lld", &l, &r);
    ll ans = (r / n - (l - 1) / n) * cnt[n] + cnt[r % n] - cnt[(l - 1) % n];
    if (q == 0)
      pr("%lld\n", ans);
    else
      pr("%lld ", ans);
  }
}
int main()
{
  //	freopen("2.in","r",stdin);
  int t;
  sc("%d", &t);
  //	t = 1;
  while (t--)
    solve();
}
