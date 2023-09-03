#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  set<int> v;
  while (cin >> s) {
    int x = 0;
    for (int i = 0; i < s.size(); i++) {
      x = x * 2 + s[i] - '0';
    }
    v.insert(x);
  }
  int len = s.size();
  for (int i = 0;; i++) {
    if (v.find(i) == v.end()) {
      string ans = "";
      for (int j = 0; j < len; j++) {
        ans += i % 2 + '0';
        i /= 2;
      }
      reverse(ans.begin(), ans.end());
      cout << ans << endl;
      break;
    }
  }
}