#include <bits/stdc++.h>

using namespace std;
int mod = 1007;

// 快速幂计算 a的b次方
int pow(int a, int b) {
  int ans = 1;
  while (b) {
    if (b & 1)
      ans = ans * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return ans % mod;
}
int main() {
  int m, n;
  cin >> m >> n;
  m %= mod;
  int sum = pow(m, n);
  int res = m * pow(m - 1, n - 1) % mod;
  cout << (sum - res + mod) % mod << endl;
  return 0;
}