#include <bits/stdc++.h>
using namespace std;
vector<int> g[10005];
bool vis[10005];
int n, m, k;
int maxd;
int ans;

void bfs(int s, int d) {
  queue<vector<int>> q;
  q.push({s, 0});
  while (!q.empty()) {
    auto t = q.front();
    q.pop();
    int u = t[0], d = t[1];
    if (d > maxd) {
      maxd = d;
      ans = u;
    } else if (d == maxd) {
      ans = min(ans, u);
    }
    for (auto v : g[u]) {
      if (!vis[v]) {
        vis[v] = 1;
        q.push({v, d + 1});
      }
    }
  }
}

int main() {
  cin >> n >> m >> k;
  while (m--) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  while (k--) {
    int a;
    cin >> a;
    memset(vis, 0, sizeof(vis));
    vis[a] = 1;
    maxd = 1;
    ans = 0x3f3f3f3f;
    bfs(a, 0);
    if (ans == 0x3f3f3f3f)
      cout << 0 << endl;
    else
      cout << ans << endl;
  }
}