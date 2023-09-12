#include <bits/stdc++.h>
using namespace std;

bool isz[65][1290][130];
int ans = 0;
bool vis[65][1290][130];
int n, m, l, t;
struct node {
  int x, y, z;
};

int bfs(int& i, int& j, int& k) {
  queue<node> q;
  int tans = 0;
  q.push({i, j, k});
  while (!q.empty()) {
    tans++;
    node t = q.front();
    q.pop();
    int tx = t.x;
    int ty = t.y;
    int tz = t.z;
    vis[tx][ty][tz] = 1;
    if (tx - 1 >= 0 && isz[tx - 1][ty][tz] && !vis[tx - 1][ty][tz]) {
      q.push({tx - 1, ty, tz});
      vis[tx - 1][ty][tz] = 1;
    }
    if (tx + 1 < l && isz[tx + 1][ty][tz] && !vis[tx + 1][ty][tz]) {
      q.push({tx + 1, ty, tz});
      vis[tx + 1][ty][tz] = 1;
    }
    if (ty - 1 >= 0 && isz[tx][ty - 1][tz] && !vis[tx][ty - 1][tz]) {
      q.push({tx, ty - 1, tz});
      vis[tx][ty - 1][tz] = 1;
    }
    if (ty + 1 < n && isz[tx][ty + 1][tz] && !vis[tx][ty + 1][tz]) {
      q.push({tx, ty + 1, tz});
      vis[tx][ty + 1][tz] = 1;
    }
    if (tz - 1 >= 0 && isz[tx][ty][tz - 1] && !vis[tx][ty][tz - 1]) {
      q.push({tx, ty, tz - 1});
      vis[tx][ty][tz - 1] = 1;
    }
    if (tz + 1 < m && isz[tx][ty][tz + 1] && !vis[tx][ty][tz + 1]) {
      q.push({tx, ty, tz + 1});
      vis[tx][ty][tz + 1] = 1;
    }
  }
  cout << tans << endl;
  return tans >= t ? tans : 0;
}
int main() {
  cin >> n >> m >> l >> t;
  memset(isz, 0, sizeof(isz));
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i < l; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < m; k++) {
        cin >> isz[i][j][k];
      }
    }
  }
  for (int i = 0; i < l; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < m; k++) {
        if (isz[i][j][k] && !vis[i][j][k]) {
          ans += bfs(i, j, k);
        }
      }
    }
  }
  cout << ans;
}