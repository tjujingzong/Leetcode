#include <bits/stdc++.h>
using namespace std;

#define inf 10000000
#define max 600

int C, N, S, M;
int bike[max];    // 每个景点的自行车数量
int G[max][max];  // 存储图
int dist[max];
int minin = inf, minout = inf;
bool visit[max] = {false};
vector<int> pre[max];  // 存储前一个景点
vector<int> path, tpath;

void dijkstra(int s) {  // 用dijkstra算法求出路径最短的几条路
  fill(dist, dist + max, inf);
  dist[s] = 0;
  while (true) {
    int u = -1, min = inf;
    for (int i = 0; i <= N; i++) {
      if (!visit[i] && dist[i] < min) {
        min = dist[i];
        u = i;
      }
    }
    if (u == -1)
      return;
    visit[u] = 1;
    for (int i = 0; i <= N; i++) {
      if (!visit[i] && G[u][i] != inf) {
        if (dist[u] + G[u][i] < dist[i]) {
          // 当有最新的路径时，清空前面的存储，将新节点放入
          dist[i] = dist[u] + G[u][i];
          pre[i].clear();
          pre[i].push_back(u);
        } else if (dist[u] + G[u][i] == dist[i]) {
          // 路径一样长时，按照题意还是要存储下来，后面再次判断
          pre[i].push_back(u);
        }
      }
    }
  }
}

void dfs(int a) {  // 用dfs算法求出所需供应和回放最少的自行车的路径
  tpath.push_back(a);
  if (a == 0) {
    int minint = 0, minoutt = 0;
    for (int i = tpath.size() - 2; i >= 0; i--) {
      // 因为此时已经将0放入末尾，找前一个路径就要减2
      int t = tpath[i];
      if (minoutt + bike[t] < C / 2) {
        minint += C / 2 - (minoutt + bike[t]);
        minoutt = 0;
      } else {
        if (bike[t] > C / 2) {
          minoutt += bike[t] - C / 2;
        } else {
          minoutt -= C / 2 - bike[t];
        }
      }
    }

    if (minint < minin) {
      minin = minint;
      path = tpath;
      minout = minoutt;
    } else if (minin == minint && minout > minoutt) {
      path = tpath;
      minout = minoutt;
    }
    tpath.pop_back();
    return;
  }
  for (int i = 0; i < pre[a].size(); i++) {
    dfs(pre[a][i]);
  }
  tpath.pop_back();
}

int main() {
  fill(G[0], G[0] + max * max, inf);
  cin >> C >> N >> S >> M;
  for (int i = 1; i <= N; i++) {
    cin >> bike[i];
  }
  for (int i = 0; i < M; i++) {
    int x, y, z;
    cin >> x >> y >> z;
    G[x][y] = z;
    G[y][x] = z;
  }
  dijkstra(0);
  dfs(S);

  cout << minin << " ";
  for (int i = path.size() - 1; i >= 0; i--) {
    cout << path[i];
    if (i)
      cout << "->";
  }
  cout << " " << minout << endl;
  return 0;
}