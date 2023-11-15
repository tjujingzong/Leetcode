#include <bits/stdc++.h>

using namespace std;
int m, n;

int ans = 0;
void dfs(int now, int f, int p) {
  if (f > n || p > m)
    return;
  if (f == n && p == m && now == 0) {
    ans++;
    return;
  }
  if (now <= 0)
    return;
  dfs(now * 2, f + 1, p);
  dfs(now - 2, f, p + 1);
}
int main() {
  cin >> n >> m;
  dfs(5, 0, 0);
  cout << ans << endl;
  return 0;
}