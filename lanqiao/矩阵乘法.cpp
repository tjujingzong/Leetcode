#include <bits/stdc++.h>

using namespace std;

int main() {
  int l, m, n;
  cin >> l >> m >> n;
  int a[l][m], b[m][n], c[l][n];
  for (int i = 0; i < l; i++)
    for (int j = 0; j < m; j++)
      cin >> a[i][j];

  for (int i = 0; i < m; i++)
    for (int j = 0; j < n; j++)
      cin >> b[i][j];

  for (int i = 0; i < l; i++) {
    for (int j = 0; j < n; j++) {
      c[i][j] = 0;
      for (int k = 0; k < m; k++) {
        c[i][j] += a[i][k] * b[k][j];
      }
    }
  }
  for (int i = 0; i < l; i++) {
    cout << c[i][0];
    for (int j = 1; j < n; j++) {
      cout << " " << c[i][j];
    }
    cout << endl;
  }

  return 0;
}