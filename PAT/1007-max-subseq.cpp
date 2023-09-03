#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  int sum = -1;
  int i = 0, j = 0;
  int ansi, ansj;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int tmp = 0;
  while (j < n) {
    tmp += a[j];
    if (tmp > sum) {
      sum = tmp;
      ansi = i;
      ansj = j;
    }
    if (tmp < 0) {
      tmp = 0;
      i = j + 1;
    }
    j++;
  }
  if (sum < 0) {
    cout << 0 << " " << a[0] << " " << a[n - 1];
  } else {
    cout << sum << " " << a[ansi] << " " << a[ansj];
  }
}