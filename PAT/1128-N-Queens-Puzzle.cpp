#include <bits/stdc++.h>
using namespace std;

int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a[n + 1];
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    bool isq = true;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (a[i] == a[j] || abs(a[i] - a[j]) == j - i) {
          isq = false;
          break;
        }
      }
    }
    if (isq) {
      cout << "YES" << endl;
    } else
      cout << "NO" << endl;
  }
}