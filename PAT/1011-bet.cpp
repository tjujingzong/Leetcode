#include <bits/stdc++.h>
using namespace std;
int main() {
  double a[3][3];
  for (int i = 0; i < 3; i++)
    for (int j = 0; j < 3; j++)
      cin >> a[i][j];
  double ans = 1;
  for (int i = 0; i < 3; i++) {
    double maxn = 0;
    int maxj = 0;
    for (int j = 0; j < 3; j++)
      if (a[i][j] > maxn) {
        maxn = a[i][j];
        maxj = j;
      }
    if (maxj == 0)
      cout << "W ";
    else if (maxj == 1)
      cout << "T ";
    else
      cout << "L ";
    ans *= maxn;
  }
  printf("%.2f", (ans * 0.65 - 1) * 2);
}