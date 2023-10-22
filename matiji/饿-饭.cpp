#include <bits/stdc++.h>

using namespace std;

int main() {
  int n, k, w;
  cin >> n >> k >> w;
  int ans = 1;
  for (int i = 0; i < 3 * w; i++) {
    ans *= (k - i);
  }
  cout << ans;
  return 0;
}