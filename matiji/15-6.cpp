#include <bits/stdc++.h>
using namespace std;
int a[200005];
bool vis[200005];
struct node
{
  int l, r;
} pig[200005];
struct Q
{
  int x, val;
  bool operator<(const Q &y) const
  {
    return val < y.val;
  }
};
priority_queue<Q> q;

int main()
{
  int n, m;
  cin >> n >> m;
  if (n / 2 < m)
  {
    cout << "Error!";
    return 0;
  }
  for (int i = 1; i <= n; i++)
  {
    cin >> a[i];
    q.push((Q){i, a[i]});
    if (i == 1)
      pig[i].l = n;
    else
      pig[i].l = i - 1;
    if (n == 1)
      pig[i].r = 1;
    else
      pig[i].r = i + 1;
  }
  int ans = 0;
  while (m--)
  {
    Q t = q.top();
    q.pop();
    if (vis[t.x])
    {
      m++;
      continue;
    }
    ans += a[t.x];
    int L = pig[t.x].l;
    int R = pig[t.x].r;
    pig[t.x].l = pig[L].l;
    pig[t.x].r = pig[R].r;
    pig[pig[L].l].r = pig[pig[R].r].l = t.x;
    vis[L] = vis[R] = 1;
    a[t.x] = a[L] + a[R] - a[t.x];
    q.push((Q){t.x, a[t.x]});
  }
  cout << ans;
  return 0;
}
