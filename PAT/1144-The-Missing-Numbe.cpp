#include <bits/stdc++.h>
using namespace std;
bool vis[1000005];

int main() {
  int n;
  memset(vis, 0, sizeof(vis));
  cin >> n;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    if (t > 0 && t < 1000005)
      vis[t] = true;
  }
  for (int i = 1; i < 1000005; i++) {
    if (!vis[i]) {
      cout << i;
      return 0;
    }
  }
}