#include <bits/stdc++.h>

using namespace std;

int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  if (a + b + c > 2 * n)
    cout << "NO";
  else
    cout << "YES";
  return 0;
}