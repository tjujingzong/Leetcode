#include <bits/stdc++.h>
using namespace std;
#define N 1000
long long fun(long long n, long long m) {
  long long ans = 1;
  for (long long i = 1; i <= m; i++) {
    ans = (ans * (n - m + i) / i) % 12520;
  }
  return ans;
}
int a[N] = {0};
int main() {
  int n, m;
  int res = 1;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int tem;
    cin >> tem;
    res *= fun(n, tem);
    n -= tem;
  }
  cout << res << endl;
  return 0;
}