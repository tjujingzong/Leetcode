#include <bits/stdc++.h>

using namespace std;
// 分解质因数
int main() {
  int n;
  cin >> n;
  int cnt = 0;
  while (n > 1) {
    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        cnt++;
        n /= i;
        break;
      }
    }
  }
  cout << cnt;
  return 0;
}