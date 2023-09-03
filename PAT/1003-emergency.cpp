#include <bits/stdc++.h>
using namespace std;
struct node {
  int pos;
  int team;
  int len;
};

bool operator<(const node& a, const node& b) {
  if (a.len != b.len)
    return a.len > b.len;
  else
    return a.team < b.team;
}

int main() {
  int n, m, c1, c2;
  cin >> n >> m >> c1 >> c2;
  vector<int> teams(n);
  for (int i = 0; i < n; i++)
    cin >> teams[i];
  vector<vector<int>> graph(n, vector<int>(n, INT_MAX));
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    graph[a][b] = c;
    graph[b][a] = c;
  }
  int maxteam = 0;
  int minlen = INT_MAX;
  int cnt = 1;
  priority_queue<node> q;
  q.push({c1, teams[c1], 0});
  vector<int> dist(n, INT_MAX);
  dist[c1] = 0;
  while (!q.empty()) {
    node cur = q.top();
    q.pop();
    if (cur.len > minlen)
      break;
    if (cur.pos == c2) {
      if (cur.len < minlen) {
        minlen = cur.len;
        maxteam = cur.team;
        cnt = 1;
      } else if (cur.len == minlen) {
        maxteam = max(maxteam, cur.team);
        cnt++;
      }
    }
    for (int i = 0; i < n; i++) {
      if (graph[cur.pos][i] != INT_MAX &&
          dist[i] >= cur.len + graph[cur.pos][i]) {
        dist[i] = cur.len + graph[cur.pos][i];
        q.push({i, cur.team + teams[i], cur.len + graph[cur.pos][i]});
      }
    }
  }
  cout << cnt << " " << maxteam << endl;
}