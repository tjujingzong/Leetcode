#include <bits/stdc++.h>
using namespace std;
int n, m, s, d;
struct node {
  int cost;
  int pp;
  int total;
  vector<int> path;

  bool operator<(const node& other) const {
    if (cost == other.cost) {
      return total < other.total;
    }
    return cost > other.cost;  // Sort by cost in ascending order
  }
};

int main() {
  cin >> n >> m >> s >> d;
  int p[n];
  for (int i = 0; i < n; i++)
    cin >> p[i];
  int cost[n][n];
  memset(cost, 0x3f, sizeof(cost));
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    cost[a][b] = cost[b][a] = c;
  }
  priority_queue<node> q;
  q.push({0, s, p[s], {s}});
  int path_num = 0;
  int min_cost = 0x3f3f3f3f;
  int max_p = 0;
  vector<int> fpath;

  while (!q.empty()) {
    node t = q.top();
    q.pop();
    if (t.cost > min_cost)
      break;
    if (t.pp == d) {
      if (min_cost > t.cost)
        min_cost = t.cost;
      if (min_cost == t.cost) {
        path_num++;
        if (max_p < t.total) {
          max_p = t.total;
          fpath = t.path;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (cost[t.pp][i] != 0x3f3f3f3f &&
          t.path.end() == find(t.path.begin(), t.path.end(), i)) {
        t.path.push_back(i);
        q.push({t.cost + cost[t.pp][i], i, t.total + p[i], t.path});
        t.path.pop_back();
      }
    }
  }
  cout << path_num << " " << max_p << endl;
  for (int i = 0; i < fpath.size(); i++) {
    if (i != fpath.size() - 1)
      cout << fpath[i] << " ";
    else
      cout << fpath[i] << endl;
  }
  return 0;
}