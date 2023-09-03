#include <bits/stdc++.h>
using namespace std;
int n, m, lp;
vector<bool> v;
void dfs(int p, int vp, int l) {
  if (vp && v[p + vp]) {
    v[p] = false;
    dfs(p + vp, vp, l - 1);
    v[p] = true;
  } else {
    if (v[p - n])
      dfs(p, -n, l);
    if (v[p - 1])
      dfs(p, -1, l);
    if (v[p + 1])
      dfs(p, 1, l);
    if (v[p + n])
      dfs(p, n, l);
    lp = min(lp, l);
  }
}
int main() {
  //	freopen("data.txt","r",stdin);
  scanf("%d %d", &n, &m);
  int lf = (n - 2) * (n - 2) - m;
  vector<int> vr(lf, 0);
  v.resize(n * n, true);
  for (int i = 0; i < n; i++) {
    v[i] = false;
    v[i * n] = false;
    v[i * n + n - 1] = false;
    v[(n - 1) * n + i] = false;
  }
  int x, y;
  for (int i = 0; i < m; i++) {
    scanf("%d %d", &x, &y);
    x--;
    y--;
    v[x * n + y] = false;
  }
  for (int i = 0; i < n * n; i++) {
    if (v[i]) {
      lp = lf - 1;
      dfs(i, 0, lf - 1);
      vr[lp]++;
    }
  }
  int bst = 0;
  for (int i = 0; i < lf; i++) {
    if (vr[i]) {
      bst = i;
      printf("%d %d\n", i, vr[i]);
      break;
    }
  }

  vector<int> vbr(bst, 0);
  lf--;
  for (int i = 0; i < n * n; i++) {
    if (v[i]) {
      v[i] = false;
      lp = lf - 1;
      for (int j = 0; j < n * n; j++)
        if (v[j])
          dfs(j, 0, lf - 1);
      if (lp < bst)
        vbr[lp]++;
      v[i] = true;
    }
  }
  bool bbst = true;
  for (int i = 0; i < bst && bbst; i++) {
    if (vbr[i]) {
      printf("%d %d", i, vbr[i]);
      bbst = false;
    }
  }
  if (bbst)
    printf("-1");
  return 0;
}