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

  int k;
  cin >> k;
  string s;
  cin >> s;
  for (int i = 0; i + k <= s.size(); i++) {
    string t = s.substr(i, k);
    int x = stoi(t);
    // cout << x << endl;
    if (isprime(x)) {
      cout << t << endl;
      return 0;
    }
  }
  cout << "404" << endl;
}