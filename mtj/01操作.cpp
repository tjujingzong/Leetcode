#include <bits/stdc++.h>

using namespace std;

int main() {
  int n, m;
  cin >> n >> m;
  string s1;
  string s2;
  cin >> s1 >> s2;
  for (int i = 0; i < m; i++) {
    if (s2[i] == '+') {
      bool flag = false;
      for (int j = s1.size() - 1; j >= 0; j--) {
        s1[j] += 1;
        if (s1[j] > '1') {
          s1[j] = '0';
          flag = true;
          continue;
        }
        flag = false;
        if (!flag)
          break;
      }
    }
    if (s2[i] == '-') {
      bool flag = false;
      for (int j = s1.size() - 1; j >= 0; j--) {
        s1[j] -= 1;
        if (s1[j] < '0') {
          s1[j] = '1';
          flag = true;
          continue;
        }
        flag = false;
        if (!flag)
          break;
      }
    }
    if (s2[i] == '*') {
      s1 += '0';
    }
    if (s2[i] == '/') {
      s1.pop_back();
    }
  }
  cout << s1 << endl;
  return 0;
}