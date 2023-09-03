#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  int i = 0;
  int a = 3 * i;
  int b = 0;
  while (true) {
    if (b > a) {
      i += 30;
      if (i > t) {
        break;
      }
    } else {
      i += 10;
      if (i > t) {
        b += 9 * (t - (i - 10));
        break;
      }
      b += 90;
    }
    a = 3 * i;
  }
  a = 3 * t;
  int ans = max(a, b);
  if (a > b)
    cout << "@_@";
  else if (a < b)
    cout << "^_^";
  else
    cout << "-_-";
  cout << " ";
  cout << ans;
}