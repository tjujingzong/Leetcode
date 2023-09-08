#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int path[n + 3][n + 3];
  memset(path, 0x3f, sizeof(path));
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    path[a][b] = path[b][a] = c;
  }
  int t;
  cin >> t;
  int minidex = 0;
  int minlen = 0x3f3f3f3f;
  for (int i = 1; i <= t; i++) {
    cout << "Path " << i << ": ";
    bool vis[n + 1];
    int dis[n + 1];
    memset(vis, false, sizeof(vis));
    memset(dis, 0, sizeof(dis));
    int unvis = n;
    int k;
    cin >> k;
    int a[k];
    for (int j = 0; j < k; j++) {
      cin >> a[j];
    }
    int s = a[0];
    int tlen = 0;
    bool isna = false;
    for (int j = 1; j < k; j++) {
      int t = a[j];
      tlen += path[s][t];
      if (tlen > 0x3f3f3f3f) {
        cout << "NA (Not a TS cycle)" << endl;
        isna = true;
        break;
      }
      s = t;
      if (!vis[t]) {
        vis[t] = true;
        unvis--;
      }
    }
    if (isna)
      continue;
    if (unvis != 0) {
      cout << tlen << " (Not a TS cycle)" << endl;
      continue;
    }
    if (k == n + 1 && a[0] == a[k - 1]) {
      cout << tlen << " (TS simple cycle)" << endl;
      if (tlen < minlen) {
        minlen = tlen;
        minidex = i;
      }
    } else {
      cout << tlen << " (TS cycle)" << endl;
      if (tlen < minlen) {
        minlen = tlen;
        minidex = i;
      }
    }
  }
  cout << "Shortest Dist(" << minidex << ") = " << minlen << endl;
}