#include <bits/stdc++.h>
using namespace std;
int cntx(int x) {
  int sum = 0;
  int i;
  for (i = 1; i * i < x; i++) {
    if (x % i == 0) {
      sum += i;
      sum += x / i;
    }
  }
  if (i * i == x)
    sum += i;
  return sum;
}
int main() {
  int n;
  cin >> n;
  cout << cntx(n);
}