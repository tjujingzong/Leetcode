#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 20;  // 你可以根据需要调整这个值，取决于节点数量的最大值
int n;
vector<vector<pair<int, int>>> graph;  // 邻接表表示的树
int dp[1 << MAX_N][MAX_N];             // 状态压缩数组

int bfs(int start) {
  queue<pair<int, int>> q;
  q.push({start, 0});
  vector<bool> visited(n, false);

  while (!q.empty()) {
    int u = q.front().first;
    int mask = q.front().second;
    q.pop();

    visited[u] = true;

    for (auto edge : graph[u]) {
      int v = edge.first;
      int w = edge.second;
      int new_mask = mask | (1 << v);

      if (!visited[v] && dp[new_mask][v] > dp[mask][u] + w) {
        dp[new_mask][v] = dp[mask][u] + w;
        q.push({v, new_mask});
      }
    }
  }

  int full_mask = (1 << n) - 1;
  int min_path = INT_MAX;

  for (int u = 0; u < n; u++) {
    if (dp[full_mask][u] < min_path) {
      min_path = dp[full_mask][u];
    }
  }

  return min_path;
}

int main() {
  cin >> n;
  graph.resize(n);

  for (int i = 0; i < n - 1; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    graph[u].push_back({v, w});
    graph[v].push_back({u, w});
  }

  int result = INT_MAX;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < (1 << n); j++) {
      dp[j][i] = INT_MAX;
    }
  }

  result = bfs(0);
  cout << result << endl;

  return 0;
}
