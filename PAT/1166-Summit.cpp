#include <bits/stdc++.h>
using namespace std;
bool graph[205][205];
int main() {
  int n, m;
  cin >> n >> m;
  memset(graph, false, sizeof(graph));
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    graph[a][b] = true;
    graph[b][a] = true;
  }
  int kk;
  cin >> kk;
  for (int ii = 1; ii <= kk; ii++) {
    int l;
    cin >> l;
    vector<int> v(l);
    unordered_set<int> s;
    for (int j = 0; j < l; j++) {
      cin >> v[j];
      s.insert(v[j]);
    }
    bool flag1 = false;
    for (int i = 0; i < l; i++) {
      for (int j = i + 1; j < l; j++) {
        if (graph[v[i]][v[j]] == false) {
          flag1 = true;
          break;
        }
      }
      if (flag1)
        break;
    }
    if (flag1) {
      printf("Area %d needs help.\n", ii);
      continue;
    }
    bool flag2 = false;
    int i;
    for (i = 1; i <= n; i++) {
      if (s.find(i) != s.end())
        continue;
      flag2 = true;
      for (int s : v) {
        flag2 = flag2 && graph[s][i];
        if (!flag2)
          break;
      }
      if (flag2)
        break;
    }
    if (flag2) {
      printf("Area %d may invite more people, such as %d.\n", ii, i);
    } else {
      printf("Area %d is OK.\n", ii);
    }
  }
}