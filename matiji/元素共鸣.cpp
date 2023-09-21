#include <bits/stdc++.h>

using namespace std;
bool isprime[10005];
void init(int x) {
  memset(isprime, 1, sizeof(isprime));
  isprime[1] = 0;
  for (int i = 2; i <= x; i++) {
    if (!isprime[i])
      continue;
    for (int j = 2 * i; j <= x; j += i) {
      isprime[j] = false;
    }
  }
}
int main() {
  int n, k;
  cin >> n >> k;
  init(n);
  vector<int> ans;
  for (int i = 2; i + k <= n; i++) {
    if (isprime[i] && isprime[i + k]) {
      ans.push_back(i);
      ans.push_back(i + k);
    }
  }
  if (ans.size() == 0)
    cout << "empty";
  else {
    for (int i = 0; i < ans.size(); i += 2) {
      cout << ans[i] << " " << ans[i + 1] << endl;
    }
  }
  return 0;
}