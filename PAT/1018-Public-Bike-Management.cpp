#include <bits/stdc++.h>
using namespace std;
int c, sta, pp, m;
int dis[505][505];
int sc[505];
bool vis[505];
int pre[505];
void dijkstra(int end) {
  int pos = 0;
  while (true) {
    int midx = -1;
    int mlen = 0x3f3f3f3f;
    for (int i = 1; i <= sta; i++) {
      if (!vis[i] && dis[0][i] < mlen) {
        mlen = dis[0][i];
        midx = i;
      }
    }
    if (midx == -1 || midx == end)
      break;
    vis[midx] = 1;
    for (int i = 1; i <= sta; i++) {
      if (!vis[i] && mlen + dis[midx][i] < dis[0][i]) {
        dis[0][i] = mlen + dis[midx][i];
        pre[i] = midx;
      } else if (!vis[i] && mlen + dis[midx][i] == dis[0][i]) {
        if (sc[midx] > sc[pre[i]]) {
          pre[i] = midx;
        }
      }
    }
  }
}
int main() {
  cin >> c >> sta >> pp >> m;
  for (int i = 1; i <= sta; i++) {
    cin >> sc[i];
  }
  memset(dis, 0x3f, sizeof(dis));
  memset(vis, 0, sizeof(vis));
  memset(pre, 0, sizeof(pre));
  for (int i = 0; i < m; i++) {
    int a, b, d;
    cin >> a >> b >> d;
    dis[a][b] = d;
    dis[b][a] = d;
  }
  dijkstra(pp);
  vector<int> v;
  int t = pp;
  int sum = 0;
  while (t != 0) {
    sum += sc[t];
    v.push_back(t);
    t = pre[t];
  }
  int ned = c / 2 * v.size() - sum;
  cout << ned << " ";
  v.push_back(0);
  for (int i = 0; i < v.size(); i++) {
    cout << v[v.size() - 1 - i];
    if (i != v.size() - 1)
      cout << "->";
  }
  cout << " " << (ned >= 0 ? 0 : sum - c / 2 * (v.size() - 1));
}