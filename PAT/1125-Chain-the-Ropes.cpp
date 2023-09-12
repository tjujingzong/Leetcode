#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int t = (a[0] + a[1]) / 2;
  for (int i = 2; i < n; i++) {
    t = (t + a[i]) / 2;
  }
  cout << t;
}