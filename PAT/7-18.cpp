#include <bits/stdc++.h>
using namespace std;
int a3, a2, a1, a0;
double ans;
double f(double x) {
  return a3 * x * x * x + a2 * x * x + a1 * x + a0;
}
int main() {
  cin >> a3 >> a2 >> a1 >> a0;
  double a, b;
  cin >> a >> b;
  double mid = (a + b) / 2;
  while (abs(f(mid) - 0) > 0.00001) {
    if (f(mid) * f(a) > 0) {
      a = mid;
    } else {
      b = mid;
    }
    mid = (a + b) / 2;
  }
  printf("%.2f", mid);
}