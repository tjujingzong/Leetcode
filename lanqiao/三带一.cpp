#include <bits/stdc++.h>
using namespace std;
int main() {
  // 请在此输入您的代码
  int n;
  cin >> n;
  while (n--) {
    string s;
    cin >> s;
    map<char, int> m;
    for (int i = 0; i < s.size(); i++) {
      m[s[i]]++;
    }
    if (m.size() != 2) {
      cout << "No" << endl;
      continue;
    }
    bool f = false;
    for (auto& it : m) {
      if (it.second != 2) {
        cout << "Yes" << endl;
        f = true;
        break;
      }
    }
    if (!f)
      cout << "No" << endl;
  }
  return 0;
}