#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int maxn = 505;
const ll mod = 1000000007;
int n;
ll r[maxn][maxn], b[maxn][maxn];

int main() {
  scanf("%d", &n);
  b[1][1] = r[0][1] = 1;
  b[1][2] = 2;
  for (int i = 0; i <= 10; i++) {
    for (int j = 2; j < n; j++) {
      for (int k = 1; k < j; k++) {
        r[i][j + 1] += b[i][k] * b[i][j - k];
        r[i][j + 1] %= mod;
        b[i + 1][j + 1] +=
            (r[i][k] + b[i][k]) * (r[i][j - k] + b[i][j - k]) % mod;
        b[i + 1][j + 1] %= mod;
      }
    }
  }
  ll ans = 0;
  for (int i = 0; i <= n; i++)
    ans = (ans + b[i][n]) % mod;
  printf("%lld", ans);
  return 0;
}
