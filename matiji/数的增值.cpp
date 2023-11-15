#include <bits/stdc++.h>

using namespace std;

int dfs(int x) {
  int ans = 0;
  for (int i = 1; i <= x / 2; i++) {
    ans += dfs(i);
  }
  return ans + 1;
}
int main() {
  int n;
  cin >> n;
  while (n >= 10) {
    n /= 10;
  }
  int ans = dfs(n);
  cout << ans << endl;
  return 0;
}