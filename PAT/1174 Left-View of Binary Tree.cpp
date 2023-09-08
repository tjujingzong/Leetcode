#include <bits/stdc++.h>
#define ll long long
using namespace std;
const int maxn = 1010, inf = 1e9;

int n, m;
struct Egde {
  int v, w, val;
};
vector<Egde> e[maxn];
int in[maxn], dis[maxn], val[maxn], pre[maxn];
int op[maxn], out[maxn];

void topo() {
  for (int i = 0; i <= n - 1; ++i) {
    dis[i] = inf;
    val[i] = 0;
    pre[i] = -1;
  }
  queue<int> q;
  for (int i = 0; i <= n - 1; ++i) {
    if (in[i] == 0) {
      q.push(i);
      dis[i] = 0;
      val[i] = 0;
    }
  }
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (auto x : e[u]) {
      int v = x.v, w = x.w;
      in[v]--;
      if (in[v] == 0)
        q.push(v);
      if (dis[v] > dis[u] + w) {
        dis[v] = dis[u] + w;
        val[v] = val[u] + x.val;
        pre[v] = u;
      } else if (dis[v] == dis[u] + w) {
        if (val[v] < val[u] + x.val) {
          val[v] = val[u] + x.val;
          pre[v] = u;
        }
      }
    }
  }
}
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; ++i) {
    int u, v, s, d;
    cin >> u >> v >> s >> d;
    e[u].push_back({v, s, d});
    in[v]++;
    out[v]++;
  }
  topo();
  int k;
  scanf("%d", &k);
  for (int i = 1; i <= k; ++i)
    scanf("%d", &op[i]);
  bool ok = 1;
  for (int i = 1; i <= k; ++i)
    if (dis[op[i]] == inf)
      ok = 0;
  if (ok) {
    puts("Okay.");
    for (int i = 1; i <= k; ++i) {
      vector<int> ans;
      for (int p = op[i]; p != -1; p = pre[p])
        ans.push_back(p);
      reverse(ans.begin(), ans.end());
      int m = ans.size();
      if (m == 1)
        printf("You may take test %d directly.\n", op[i]);
      else
        for (int i = 1; i <= m; ++i)
          printf("%d%s", ans[i - 1], i == m ? "\n" : "->");
    }
  } else {
    puts("Impossible.");
    for (int i = 1; i <= k; ++i) {
      if (out[op[i]] != 0)
        puts("Error.");
      else
        printf("You may take test %d directly.\n", op[i]);
    }
  }
  return 0;
}
