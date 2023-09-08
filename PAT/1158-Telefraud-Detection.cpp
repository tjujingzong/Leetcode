#include <bits/stdc++.h>
using namespace std;
int cnt[1005][1005];
int fa[1005];
int back[1005];
int find(int x) {
  while (fa[x] != x) {
    fa[x] = fa[fa[x]];
    x = fa[x];
  }
  return x;
}
void merge(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  if (fx != fy)
    fa[fx] = fy;
}
int main() {
  int t, n, m;
  memset(back, 0, sizeof(back));
  memset(cnt, 0, sizeof(cnt));
  scanf("%d%d%d", &t, &n, &m);
  for (int i = 0; i < m; i++) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    cnt[a][b] += c;
  }
  vector<int> ans;
  for (int i = 1; i <= n; i++) {
    int num = 0;
    int back = 0;
    for (int j = 1; j <= n; j++) {
      if (cnt[i][j] > 0 && cnt[i][j] <= 5) {
        num++;
        if (cnt[j][i] > 0)
          back++;
      }
    }
    if (num > t && back * 5 <= num)
      ans.push_back(i);
  }
  if (ans.size() == 0) {
    cout << "None" << endl;
    return 0;
  }
  for (int i = 0; i < ans.size(); i++)
    fa[ans[i]] = ans[i];
  for (int i = 0; i < ans.size(); i++) {
    for (int j = i + 1; j < ans.size(); j++) {
      if (cnt[ans[i]][ans[j]] > 0 && cnt[ans[j]][ans[i]] > 0) {
        merge(ans[i], ans[j]);
      }
    }
  }
  bool vis[1005];
  memset(vis, false, sizeof(vis));
  for (int i = 0; i < ans.size(); i++) {
    if (vis[ans[i]])
      continue;
    vis[ans[i]] = true;
    cout << ans[i];
    for (int j = i + 1; j < ans.size(); j++) {
      if (vis[ans[j]])
        continue;
      if (find(ans[i]) == find(ans[j])) {
        cout << " " << ans[j];
        vis[ans[j]] = true;
      }
    }
    cout << endl;
  }
}