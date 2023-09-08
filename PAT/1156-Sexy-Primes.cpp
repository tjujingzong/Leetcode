#include <bits/stdc++.h>
using namespace std;
bool isprime(int i) {
  if (i <= 1)
    return false;
  for (int j = 2; j <= sqrt(i); j++) {
    if (i % j == 0)
      return false;
  }
  return true;
}
int main() {
  int n;
  cin >> n;
  if (isprime(n) && isprime(n + 6)) {
    cout << "Yes" << endl;
    cout << n - 6 << endl;
    return 0;
  } else if (isprime(n) && isprime(n - 6)) {
    cout << "Yes" << endl;
    cout << n + 6 << endl;
    return 0;
  } else {
    cout << "No" << endl;
    for (int i = n + 1; i <= n + 10000; i++) {
      if (isprime(i) && isprime(i + 6) || isprime(i) && isprime(i - 6)) {
        cout << i << endl;
        return 0;
      }
    }
  }
}