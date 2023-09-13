#include <bits/stdc++.h>

using namespace std;
int ans[2005];
int main() {
  int c;
  cin >> c;
  int res = 0;
  for (int j = 1; j <= 2000; j++) {
    for (int k = 1; k <= j; k++) {
      if (__gcd(k, j) == 1)
        res++;
    }
    for (int i = 1; i <= j - 1; i++) {
      if (__gcd(i, j) == 1)
        res++;
    }
    ans[j] = res + 2;
  }
  for (int i = 1; i <= c; i++) {
    int n;
    cin >> n;
    cout << i << " " << n << " ";
    cout << ans[n] << endl;
  }
  return 0;
}