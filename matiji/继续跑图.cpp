#include <bits/stdc++.h>

using namespace std;
struct edge {
  int dest;
  int w;
};

int main() {
  int n, m;
  cin >> n >> m;
  vector<edge> G[n + 1];
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    G[a].push_back({b, c});
  }
  int maxi = 1;
  for (int i = 1; i <= n; i++) {
    if (G[i].size() > G[maxi].size()) {
      maxi = i;
    }
  }
  sort(G[maxi].begin(), G[maxi].end(), [](edge a, edge b) {
    if (a.dest == b.dest)
      return a.w < b.w;
    return a.dest < b.dest;
  });
  cout << maxi << endl;
  for (auto e : G[maxi]) {
    cout << e.dest << " " << e.w << endl;
  }
  return 0;
}