#include <bits/stdc++.h>
using namespace std;
vector<int> g[1005];
int fa[1005];
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
  fa[fy] = fx;
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    fa[i] = i;
  }
  for (int i = 0; i < n; i++) {
    int k;
    scanf("%d:", &k);
    for (int j = 0; j < k; j++) {
      int t;
      cin >> t;
      g[t].push_back(i);
    }
  }
  for (int i = 0; i < 1005; i++) {
    if (g[i].size() > 1) {
      for (int& num : g[i]) {
        merge(g[i][0], num);
      }
    }
  }
  unordered_map<int, int> mp;
  for (int i = 0; i < n; i++) {
    mp[find(i)]++;
  }
  vector<int> v;
  for (auto& p : mp) {
    v.push_back(p.second);
  }
  sort(v.begin(), v.end(), [](int a, int b) { return a > b; });
  cout << v.size() << endl;
  for (int i = 0; i < v.size(); i++) {
    cout << v[i];
    if (i != v.size() - 1) {
      cout << " ";
    }
  }
}