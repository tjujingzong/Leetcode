#include <bits/stdc++.h>
using namespace std;
class unionfind {
 public:
  int n;
  vector<int> fa;
  unionfind(int n) : n(n) {
    fa.resize(n);
    for (int i = 0; i < n; i++) {
      fa[i] = i;
    }
  }
  int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
  void merge(int x, int y) { fa[find(x)] = find(y); }
};
int main() {
  int n;
  scanf("%d", &n);
  unionfind uf(n);
  int m;
  scanf("%d", &m);
  while (m-- > 0) {
    int x, y;
    scanf("%d%d", &x, &y);
    uf.merge(x, y);
  }
  int k;
  scanf("%d", &k);
  while (k-- > 0) {
    int x, y;
    scanf("%d%d", &x, &y);
    if (uf.find(x) == uf.find(y)) {
      printf("Yes\n");
    } else {
      printf("No\n");
    }
  }
}