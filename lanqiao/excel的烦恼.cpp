#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t-- > 0) {
    string s;
    cin >> s;
    bool flag = false;
    if (s[0] == 'R') {
      if (s.rfind('C') != string::npos) {
        int i = s.rfind('C');
        int cnt = 0;
        for (int j = 1; j < i; j++) {
          if (isdigit(s[j])) {
            cnt++;
          }
        }
        if (cnt == i - 1 && i != 1) {
          flag = true;
          int n1 = stoi(s.substr(1, i - 1));
          int n2 = stoi(s.substr(i + 1));
          string ans;
          while (n2) {
            int t = n2 % 26;
            if (t == 0) {
              ans += 'Z';
              n2 -= 26;
            } else {
              ans += 'A' + t - 1;
            }
            n2 /= 26;
          }
          reverse(ans.begin(), ans.end());
          cout << ans << n1 << endl;
        }
      }
    }
    if (!flag) {
      int i;
      for (i = 0; i < s.size(); i++) {
        if (isdigit(s[i])) {
          break;
        }
      }
      string s1 = s.substr(0, i);
      string s2 = s.substr(i);
      int c_num = 0;
      for (int j = 0; j < s1.size(); j++) {
        c_num = c_num * 26 + s1[j] - 'A' + 1;
      }
      cout << "R" << s2 << "C" << c_num << endl;
    }
  }
}