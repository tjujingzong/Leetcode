#include <bits/stdc++.h>
using namespace std;
bool connected[210][210];

int main() {
  memset(connected, 0, sizeof(connected));
  int n, m;
  cin >> n >> m;
  while (m--) {
    int a, b;
    cin >> a >> b;
    connected[a][b] = 1;
    connected[b][a] = 1;
  }
  int k;
  cin >> k;
  while (k--) {
    int t;
    cin >> t;
    int a[t];
    bool vis[n];
    memset(vis, 0, sizeof(vis));
    for (int i = 0; i < t; i++) {
      cin >> a[i];
    }
    if (t != n + 1) {
      cout << "NO" << endl;
      continue;
    } else if (a[0] != a[t - 1]) {
      cout << "NO" << endl;
      continue;
    }
    bool ishp = true;
    for (int i = 1; i < t; i++) {
      vis[a[i]] = 1;
      if (!connected[a[i]][a[i - 1]]) {
        ishp = false;
        break;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        ishp = false;
        break;
      }
    }
    if (ishp) {
      cout << "YES" << endl;
    } else
      cout << "NO" << endl;
  }
}