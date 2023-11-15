#include <bits/stdc++.h>

using namespace std;
int te, fe, s;
int t, f, n, m;
const int maxn = 40005;
vector<int> v[maxn];
int p1[maxn], p2[maxn], d[maxn];
void bfs(int start, int val[]) {
  for (int i = 1; i <= n; i++)
    val[i] = n + 1;
  queue<int> Q;
  Q.push(start);
  val[start] = 0;
  while (!Q.empty()) {
    int cur = Q.front();
    Q.pop();
    for (int i = 0; i < v[cur].size(); i++) {
      int d = v[cur][i];
      if (val[d] > val[cur] + 1) {
        Q.push(d);
        val[d] = val[cur] + 1;
      }
    }
  }
}
int main() {
  scanf("%d %d %d", &te, &fe, &s);
  scanf("%d %d %d %d", &t, &f, &n, &m);
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    v[a].push_back(b);
    v[b].push_back(a);
  }
  // 求三个点的最短路
  bfs(t, p1);
  bfs(f, p2);
  bfs(n, d);
  if (p1[n] == n + 1 || p2[n] == n + 1) {
    printf("-1");
  } else {
    int res = p1[n] * te + p2[n] * fe;
    // 遍历两人在i点集合的结果
    for (int i = 1; i < n; i++) {
      int cur = p1[i] * te + p2[i] * fe + d[i] * (te + fe - s);
      res = min(res, cur);
    }
    printf("%d", res);
  }

  return 0;
}