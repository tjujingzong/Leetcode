#include <bits/stdc++.h>
using namespace std;

bool isprime(int x) {
  if (x == 1)
    return false;
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0)
      return false;
  }
  return true;
};
int main() {
  string s;
  cin >> s;
  int n = s.size();
  int cnt = 0;

  for (int i = 0; i < 8; i++) {
    string sub = s.substr(i, s.size() - i);
    int num = stoi(sub);
    if (isprime(num)) {
      cout << sub << " Yes" << endl;
      cnt++;
    } else {
      cout << sub << " No" << endl;
    }
  }
  if (cnt == 8)
    cout << "All Prime!" << endl;
}