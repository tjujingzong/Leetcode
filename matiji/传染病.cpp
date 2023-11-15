#include <bits/stdc++.h>

using namespace std;
char grid[11][11][11];
bool vis[11][11][11];
int n, m, kk;
int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
struct pos {
  int x, y, z;
};

int bfs(int x, int y, int z) {
  int ans = 0;
  queue<pos> q;
  q.push({x, y, z});
  while (!q.empty()) {
    pos t = q.front();
    q.pop();
    int tx = t.x;
    int ty = t.y;
    int tz = t.z;
    vis[tx][ty][tz] = 1;
    ans++;
    for (int i = 0; i < 6; i++) {
      int nx = tx + dx[i];
      int ny = ty + dy[i];
      int nz = tz + dz[i];
      if (nx >= 0 && nx < kk && ny >= 0 && ny < n && nz >= 0 && nz < m &&
          !vis[nx][ny][nz] && grid[nx][ny][nz] == '.') {
        q.push({nx, ny, nz});
        vis[nx][ny][nz] = 1;
      }
    }
  }
  return ans;
}
int main() {
  cin >> kk >> n >> m;
  for (int i = 0; i < kk; i++)
    for (int j = 0; j < n; j++)
      for (int k = 0; k < m; k++)
        cin >> grid[i][j][k];
  int x, y;
  cin >> x >> y;
  int ans = bfs(0, x - 1, y - 1);
  cout << ans;
  return 0;
}