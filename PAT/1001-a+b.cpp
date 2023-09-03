#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int c = a + b;
  string s = to_string(c);
  string ans = "";
  if (s[0] == '-') {
    ans += '-';
    s.erase(s.begin());
  }
  int len = s.length();
  for (int i = 0; i < len; i++) {
    ans += s[i];
    if ((len - i - 1) % 3 == 0 && i != len - 1)
      ans += ',';
  }
  cout << ans << endl;
}