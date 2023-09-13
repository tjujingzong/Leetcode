#include <bits/stdc++.h>

using namespace std;
bool isprime(int x) {
  if (x <= 1)
    return false;
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0)
      return false;
  }
  return true;
}
int main() {
  int n;
  cin >> n;
  if (isprime(n))
    cout << 1;
  else if (n % 2 == 0 || isprime(n - 2))
    cout << 2;
  else
    cout << 3;
  return 0;
}