#include <bits/stdc++.h>
using namespace std;
int n;
int rk[10005];
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
  cin >> n;
  int i = 1;
  memset(rk, 0, sizeof(rk));
  for (int j = 0; j < n; j++) {
    int t;
    cin >> t;
    rk[t] = i;
    i++;
  }
  int k;
  cin >> k;
  unordered_set<int> s;
  for (int j = 0; j < k; j++) {
    int t;
    cin >> t;

    printf("%04d: ", t);
    if (s.count(t) > 0) {
      cout << "Checked" << endl;
    } else if (rk[t] == 0) {
      cout << "Are you kidding?" << endl;
      continue;
    } else if (rk[t] == 1) {
      cout << "Mystery Award" << endl;
    } else if (isprime(rk[t])) {
      cout << "Minion" << endl;
    } else
      cout << "Chocolate" << endl;
    s.insert(t);
  }
}