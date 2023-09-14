#include <bits/stdc++.h>
using namespace std;
int fa[10005];
int find(int x) {
  while (x != fa[x]) {
    fa[x] = fa[fa[x]];
    x = fa[x];
  }
  return x;
}

void merge(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  fa[fx] = fy;
}

int main() {
  for (int i = 0; i < 10005; i++) {
    fa[i] = i;
  }
  int k;
  cin >> k;
  int maxx = 0;
  while (k--) {
    int t;
    cin >> t;
    vector<int> v;
    while (t--) {
      int tmp;
      cin >> tmp;
      maxx = max(maxx, tmp);
      v.push_back(tmp);
    }
    for (int i = 1; i < v.size(); i++) {
      merge(v[0], v[i]);
    }
  }
  unordered_set<int> s;
  for (int i = 1; i <= maxx; i++) {
    s.insert(find(i));
  }
  cout << s.size() << " " << maxx << endl;
  cin >> k;
  while (k--) {
    int a, b;
    cin >> a >> b;
    if (find(a) == find(b))
      cout << "Yes" << endl;
    else
      cout << "No" << endl;
  }
}
