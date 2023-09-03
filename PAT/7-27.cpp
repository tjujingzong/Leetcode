#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 1; i <= k; i++) {
    for (int j = 0; j < n - i; j++) {
      if (a[j] > a[j + 1])
        swap(a[j], a[j + 1]);
    }
  }
  for (int i = 0; i < n; i++) {
    cout << a[i];
    if (i != n - 1)
      cout << " ";
  }
}