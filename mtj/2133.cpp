#include <bits/stdc++.h>
using namespace std;
#define ll long long
const int N = 2e6 + 7;
struct NODE
{
  ll nex, coef, expn;
} node[N];
int n, m, head, tail, pos;
ll coefA[N], expnA[N], coefB[N], expnB[N];
void insert(int curr, ll val1, ll val2)
{
  node[++pos].coef = val1;
  node[pos].expn = val2;
  node[pos].nex = node[curr].nex;
  node[curr].nex = pos;
  if (!node[pos].nex)
    tail = pos;
}
int main()
{
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++)
    scanf("%lld%lld", &coefA[i], &expnA[i]);
  for (int i = 1; i <= m; i++)
    scanf("%lld%lld", &coefB[i], &expnB[i]);
  int l = 1, r = 1;
  while (l <= n && r <= n)
  {
    if (expnA[l] == expnB[r])
    {
      insert(tail, coefA[l] + coefB[r], expnA[l]);
      l++, r++;
    }
    else
    {
      if (expnA[l] < expnB[r])
      {
        insert(tail, coefA[l], expnA[l]);
        l++;
      }
      else
      {
        insert(tail, coefB[r], expnB[r]);
        r++;
      }
    }
  }
  while (l <= n)
  {
    insert(tail, coefA[l], expnA[l]);
    l++;
  }
  while (r <= m)
  {
    insert(tail, coefB[r], expnB[r]);
    r++;
  }
  for (int i = node[head].nex; i != 0; i = node[i].nex)
    if (node[i].coef != 0)
      printf("%lld %lld\n", node[i].coef, node[i].expn);
  return 0;
}
