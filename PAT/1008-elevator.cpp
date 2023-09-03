#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int ans = 0;
  int last = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] > last) {
      ans += 6 * (a[i] - last);
    } else {
      ans += 4 * (last - a[i]);
    }
    last = a[i];
    ans += 5;
  }
  cout << ans;
}