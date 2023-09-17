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
string tostrd(int n, int d) {
  string ans = "";
  while (n > 0) {
    ans += (n % d + '0');
    n /= d;
  }
  return ans;
}
int toid(string s, int d) {
  int n2 = 0;
  for (int i = 0; i < s.size(); i++) {
    n2 += s[i] - '0';
    if (i != s.size() - 1)
      n2 *= d;
  }
  return n2;
}
int main() {
  int n;
  int d;
  while (true) {
    cin >> n >> d;
    if (n < 0)
      break;
    if (!isprime(n)) {
      cout << "No" << endl;
      continue;
    }
    string s = tostrd(n, d);
    // cout << s << endl;
    int n2 = toid(s, d);
    // cout << n2;
    if (!isprime(n2)) {
      cout << "No" << endl;
    } else
      cout << "Yes" << endl;
  }
  return 0;
}