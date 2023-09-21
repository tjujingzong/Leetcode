#include <bits/stdc++.h>
using namespace std;
int a[15];
int n;
int dfs(int i, int x) {  // 从i开始 乘x个
  int res = 0;
  if (i + x > n + 1)
    return 0;
  if (x == 1)
    return a[i];
  for (int j = i + 1; j <= n; j++) {
    res += a[i] * dfs(j, x - 1);
  }
  return res;
}

int cal(int x) {
  int res = 0;
  for (int i = 1; i <= n; i++) {
    res += dfs(i, x);
  }
  return res;
}

int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    a[i] = -a[i];
  }
  vector<int> ans;
  for (int i = 1; i <= n; i++) {
    ans.push_back(cal(i));
  }
  cout << ans[0];
  for (int i = 1; i < n; i++) {
    cout << " " << ans[i];
  }
}