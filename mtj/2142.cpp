#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
int n;
int c[N], chg[N];
int lowbit(int x)
{
  return x & -x;
}
void add(int x)
{
  for (; x < N; x += lowbit(x))
    c[x]++;
}
int sum(int x)
{
  int ret = 0;
  for (; x > 0; x -= lowbit(x))
    ret += c[x];
  return ret;
}
int main()
{
  cin >> n;
  int x = 0, maxx = 0;
  for (int i = 1; i <= n; i++)
  {
    cin >> x;
    maxx = max(maxx, x);
    int cnt = sum(x);
    if (cnt == i - 1)
      chg[maxx]--;
    else if (cnt == i - 2)
      chg[maxx]++;
    add(x);
  }
  int ans = 1;
  for (int i = 1; i <= n; i++)
    if (chg[i] > chg[ans])
      ans = i;
  cout << ans << endl;
  return 0;
}
