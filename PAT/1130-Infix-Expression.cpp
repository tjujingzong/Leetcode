#include <bits/stdc++.h>
using namespace std;
struct node {
  string data;
  int l, r;
  bool isleaf = false;
};
node a[30];
bool isroot[20];
int n;
int roott = 0;
void dfs(int root) {
  if (root != roott && !a[root].isleaf)
    cout << "(";
  if (a[root].l != -1) {
    dfs(a[root].l);
  }

  cout << a[root].data;
  if (a[root].r != -1) {
    dfs(a[root].r);
  }
  if (root != roott && !a[root].isleaf)
    cout << ")";
}
int main() {
  cin >> n;
  memset(isroot, 1, sizeof(isroot));
  for (int i = 1; i <= n; i++) {
    cin >> a[i].data >> a[i].l >> a[i].r;
    isroot[a[i].l] = false;
    isroot[a[i].r] = false;
    if (a[i].l == -1 && a[i].r == -1)
      a[i].isleaf = true;
  }

  for (int i = 1; i <= n; i++) {
    if (isroot[i])
      roott = i;
  }
  dfs(roott);
}