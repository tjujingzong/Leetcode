#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int m;
  cin >> n >> m;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int l = 0, r = 0;
  int sum = 0;
  int temp = 0;
  while (r < n) {
    temp += a[r];
    if (temp <= m) {
      r++;
    } else {
      int len = r - l;
      sum += len;
      temp -= a[l];
      temp -= a[r];
      l++;
    }
  }
  int len = r - l;
  sum += len * (len + 1) / 2;
  cout << sum;
}