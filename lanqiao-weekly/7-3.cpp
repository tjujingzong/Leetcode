#include <bits/stdc++.h>
using namespace std;
int main() {
  // 请在此输入您的代码
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int i = 0;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] % 2 == 1) {
      cout << a[i];
      cnt++;
    }
    if (cnt != n) {
      cout << " ";
    }
  }
  for (int i = 0; i < n; i++) {
    if (a[i] % 2 == 0) {
      cout << a[i] << " ";
      cnt++;
    }
    if (cnt != n) {
      cout << " ";
    }
  }
  return 0;
}