#include <algorithm>
#include <bitset>
#include <cmath>
#include <cstdio>
#include <cstring>
#include <ctime>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <stack>
#include <vector>
using namespace std;
typedef unsigned long long ull;
typedef long long LL;
const int maxn = 1e2 + 10;
const int INF = 0x7FFFFFFF;
int n, ch[maxn][2], root = 0, f[maxn], cnt, flag, res;
int a[maxn], b[maxn], c[maxn], fa[maxn], fb[maxn], fc[maxn], t[maxn];
char s[5];

int get() {
  scanf("%s", s);
  if (s[0] == '-')
    return 0;
  int res = 0;
  for (int i = 0; s[i]; i++)
    res = res * 10 + s[i] - '0';
  return res;
}

bool dfs(int& x, int al, int ar, int bl, int br, int cl, int cr) {
  if (al > ar) {
    x = 0;
    return true;
  }
  for (int i = al; i <= ar; i++) {
    if (a[i] && b[bl] && a[i] != b[bl])
      continue;
    if (a[i] && c[cr] && a[i] != c[cr])
      continue;
    if (c[cr] && b[bl] && c[cr] != b[bl])
      continue;
    t[i] = max(a[i], max(b[bl], c[cr]));
    if (fa[t[i]] && fa[t[i]] != i)
      continue;
    if (fb[t[i]] && fb[t[i]] != bl)
      continue;
    if (fc[t[i]] && fc[t[i]] != cr)
      continue;
    x = i;
    if (!dfs(ch[x][0], al, i - 1, bl + 1, bl + i - al, cl, cl + i - al - 1))
      continue;
    if (!dfs(ch[x][1], i + 1, ar, bl + 1 + i - al, br, cl + i - al, cr - 1))
      continue;
    return true;
  }
  return false;
}

void dfs(int x, int y) {
  if (!x)
    return;
  if (y == 2) {
    printf("%s%d", flag ? " " : "", t[x]);
    flag = 1;
  }
  dfs(ch[x][0], y);
  if (y == 1) {
    printf("%s%d", flag ? " " : "", t[x]);
    flag = 1;
  }
  dfs(ch[x][1], y);
  if (y == 3) {
    printf("%s%d", flag ? " " : "", t[x]);
    flag = 1;
  }
}

void bfs(int x) {
  queue<int> p;
  p.push(x);
  while (!p.empty()) {
    int q = p.front();
    p.pop();
    printf("%s%d", flag ? " " : "", t[q]);
    flag = 1;
    if (ch[q][0])
      p.push(ch[q][0]);
    if (ch[q][1])
      p.push(ch[q][1]);
  }
}

int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    a[i] = get(), f[a[i]]++, fa[a[i]] = i;
  for (int i = 1; i <= n; i++)
    b[i] = get(), f[b[i]]++, fb[b[i]] = i;
  for (int i = 1; i <= n; i++)
    c[i] = get(), f[c[i]]++, fc[c[i]] = i;
  for (int i = 1; i <= n; i++)
    if (!f[i]) {
      cnt++;
      res = i;
    }
  if (cnt > 1 || !dfs(root, 1, n, 1, n, 1, n))
    printf("Impossible\n");
  else {
    for (int i = 1; i <= n; i++)
      if (!t[i])
        t[i] = res;
    flag = 0;
    dfs(root, 1);
    putchar(10);
    flag = 0;
    dfs(root, 2);
    putchar(10);
    flag = 0;
    dfs(root, 3);
    putchar(10);
    flag = 0;
    bfs(root);
    putchar(10);
  }
  return 0;
}
