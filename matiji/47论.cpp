#include <bits/stdc++.h>

using namespace std;
vector<long long> a;
int n;
bool check(long long x) {
  int cnt4 = 0, cnt7 = 0;
  while (x) {
    if (x % 10 == 4)
      cnt4++;
    else if (x % 10 == 7)
      cnt7++;
    x /= 10;
  }
  return cnt4 == cnt7;
}
void dfs(long long x) {
  if (x > 4444477777)
    return;
  if (check(x))
    a.push_back(x);
  dfs(x * 10 + 4);
  dfs(x * 10 + 7);
}
int main() {
  cin >> n;
  dfs(4);
  dfs(7);
  sort(a.begin(), a.end());
  int i = lower_bound(a.begin(), a.end(), n) - a.begin();
  cout << a[i];
  return 0;
}