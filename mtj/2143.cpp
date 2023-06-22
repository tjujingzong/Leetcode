#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
#define int long long // 有时候觉得1l麻烦,就可以用。但记得改si
struct NODE
{
  int l, r, val, lz;
} tree[4 * N];
int a[N];
void build(int p, int l, int r)
{
  tree[p].l = l, tree[p].r = r;
  if (l == r)
  {
    tree[p].val = a[l];
    return;
  }
  int mid = l + ((r - l) >> 1);
  build(p * 2, l, mid);
  build(p * 2 + 1, mid + 1, r);
  tree[p].val = tree[p * 2].val + tree[p * 2 + 1].val;
}
void lazy(int p, int v)
{
  int s = tree[p].l, t = tree[p].r;
  tree[p].val += (t - s + 1) * v, tree[p].lz += v;
}
void pushdown(int p)
{
  lazy(2 * p, tree[p].lz);
  lazy(2 * p + 1, tree[p].lz);
  tree[p].lz = 0;
}
void update(int l, int r, int c, int p)
{
  int s = tree[p].l, t = tree[p].r;
  if (l <= s && t <= r)
    return lazy(p, c);
  if (tree[p].lz && s != t)
    pushdown(p);
  int mid = s + ((t - s) >> 1);
  if (l <= mid)
    update(l, r, c, p * 2);
  if (r > mid)
    update(l, r, c, p * 2 + 1);
  tree[p].val = tree[p * 2].val + tree[p * 2 + 1].val;
}
int query(int l, int r, int p)
{
  int s = tree[p].l, t = tree[p].r;
  if (l <= s && t <= r)
    return tree[p].val;
  if (tree[p].lz)
    pushdown(p);
  int mid = s + ((t - s) >> 1), sum = 0;
  if (l <= mid)
    sum = query(l, r, p * 2);
  if (r > mid)
    sum += query(l, r, p * 2 + 1);
  return sum;
}

signed main()
{
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
    cin >> a[i];
  build(1, 1, n);
  while (m--)
  {
    int op, x, y, k;
    cin >> op;
    if(op == 1)
    {
      cin >> x >> y >> k;
      update(x, y, k, 1);
    }
    else
    {
      cin >> x >> y;
      cout << query(x, y, 1) << endl;
    }
  }
  return 0;
}
