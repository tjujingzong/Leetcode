#include <cstring>
#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;
const int N = 10010;
vector<int> e[N], ans, res;
unordered_map<int, int> mp;
int a, b, dis, last;
bool vis[N];
void dfs(int st, int en, int pre, int cnt)  // cnt为换乘次数，pre为上一个点
{
  if (dis < ans.size())
    return;  // 剪枝 dis最短路径
  if (dis == ans.size() && cnt > last)
    return;  // 剪枝 last当前最短路径的换乘次数
  if (st == en) {
    dis = ans.size();
    res = ans;
    last = cnt;
    return;
  }
  for (auto it : e[st]) {
    if (vis[it])
      continue;
    ans.push_back(it), vis[it] = true;
    int x = mp[st * N + it] == mp[pre * N + st]
                ? 0
                : 1;  // 判断是否换乘,pre记录上一个点
    dfs(it, en, st, cnt + x);
    ans.pop_back();
    vis[it] = false;
  }
}
void solve() {
  int st, en;
  cin >> st >> en;
  dis = 1e9, last = 1e9;
  ans.clear();
  ans.push_back(st);
  vis[st] = true;
  dfs(st, en, -1, 0);
  vis[st] = false;
  cout << res.size() - 1 << endl;
  int pre = 0;
  for (int i = 1; i < res.size(); i++) {
    if (mp[res[i - 1] * N + res[i]] != pre) {
      if (pre != 0)
        printf("Take Line#%d from %04d to %04d.\n", pre, st, res[i - 1]);
      pre = mp[res[i - 1] * N + res[i]];
      st = res[i - 1];
    }
  }
  printf("Take Line#%d from %04d to %04d.\n", pre, st, en);
}
int main() {
  int tt;
  cin >> tt;
  for (int k = 1; k <= tt; k++) {
    int m;
    cin >> m >> a;
    for (int i = 0; i < m - 1; i++) {
      cin >> b;
      e[a].push_back(b), e[b].push_back(a);  // 无向边
      mp[a * N + b] = mp[b * N + a] = k;     // 相邻两点保存路线标号
      a = b;
    }
  }
  int T;
  cin >> T;
  while (T--)
    solve();
  return 0;
}