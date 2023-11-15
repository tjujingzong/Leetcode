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
  for (int i = 1; i <= n; i++) {
    int maxi = -1;
    int maxw = -1;
    for (auto e : G[i]) {
      if (e.w > maxw) {
        maxw = e.w;
        maxi = e.dest;
      }
    }
    if (maxi != -1)
      cout << maxi << " " << maxw;
    else
      cout << 0;
    cout << endl;
  }
  return 0;
}