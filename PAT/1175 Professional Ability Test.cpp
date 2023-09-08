#include <bits/stdc++.h>
using namespace std;
int n, m;
struct path {
  int from, to;
  int s, d;
};
struct ans {
  string s;
  int ts, td;
};
ans anss[1005];
path p[1005];
int indegree[1005];
bool isvisited[1005];

void dfs(int i, int& ts, int& td, path p[], string s) {
  isvisited[i] = true;
  if (anss[i].s != "") {
    anss[i].s = s;
    anss[i].ts = ts;
    anss[i].td = td;
  }
  for (int j = 0; j < m; j++) {
    if (p[j].from == i&& !isvisited[p[j].to]&& indegree[p[j].to] == 0) {
      ts += p[j].s;
      td += p[j].d;
      dfs(p[j].to, ts, td, p, s + "->" + to_string(p[j].to));
      ts -= p[j].s;
      td -= p[j].d;
    }
  }
}
int main() {
  cin >> n >> m;
  memset(indegree, 0, sizeof(indegree));
  memset(isvisited, false, sizeof(isvisited));
  for (int i = 0; i < m; i++) {
    cin >> p[i].from >> p[i].to >> p[i].s >> p[i].d;
    indegree[p[i].to]++;
  }

  for (int i = 0; i < n; i++) {
    anss[i].s = "";
  }
  for (int i = 0; i < n; i++) {
    if (!isvisited[i] && indegree[i] == 0) {
      anss[i].s = "You may take test " + to_string(i) + " directly.";
      for (int j = 0; j < m; j++) {
        if (p[j].from == i) {
          indegree[p[j].to]--;
        }
      }
      dfs(i, anss[i].ts, anss[i].td, p, to_string(i));
    }
  }
}