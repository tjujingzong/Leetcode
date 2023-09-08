#include <bits/stdc++.h>

using namespace std;

int main() {
  string s;
  cin >> s;
  int m;
  cin >> m;
  while (m-- > 0) {
    int l1, r1;
    cin >> l1 >> r1;
    string s1 = s.substr(l1 - 1, r1 - l1 + 1);
    int l2, r2;
    cin >> l2 >> r2;
    string s2 = s.substr(l2 - 1, r2 - l2 + 1);
    if (s1 == s2)
      cout << "Yes" << endl;
    else
      cout << "No" << endl;
  }

  return 0;
}