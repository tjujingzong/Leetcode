#include <bits/stdc++.h>

using namespace std;
const int N = 107, inf = 0x3f3f3f3f;
bool g[N][N];
int n, m, w[N], ans = inf;

int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
    cin >> w[i];
  for (int i = 1, u, v; i <= m; i++) {
    cin >> u >> v;
    g[u][v] = g[v][u] = true;
  }
  for (int i = 1; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      for (int k = j + 1; k <= n; k++) {
        if (g[i][j] && g[j][k] && g[k][i])
          ans = min(ans, w[i] + w[j] + w[k]);
      }
    }
  }
  cout << (ans == inf ? -1 : ans);
  return 0;
}