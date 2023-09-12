#include <bits/stdc++.h>
using namespace std;
vector<int> g[505];
bool vis[505];
int n, m;
void dfs(int x) {
  vis[x] = true;
  for (int& next : g[x]) {
    if (!vis[next]) {
      dfs(next);
    }
  }
}
int main() {
  cin >> n >> m;
  memset(vis, 0, sizeof(vis));
  int ind[n + 1];
  memset(ind, 0, sizeof(ind));
  while (m--) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
    ind[a]++;
    ind[b]++;
  }
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (ind[i] % 2 == 1)
      cnt++;
    cout << ind[i];
    if (i != n)
      cout << " ";
    else
      cout << endl;
  }
  dfs(1);
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) {
      cout << "Non-Eulerian";
      return 0;
    }
  }
  if (cnt == 0)
    cout << "Eulerian";
  else if (cnt == 2)
    cout << "Semi-Eulerian";
  else
    cout << "Non-Eulerian";
}