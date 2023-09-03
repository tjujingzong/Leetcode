#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  while (n-- > 0) {
    int x;
    scanf("%d", &x);
    string s;
    if (x == 0)
      s = "0";
    bool flag = false;
    if (x < 0) {
      flag = true;
      x = -x;
    }
    while (x) {
      int t = x % 3;
      if (t == 0)
        s += '0';
      else if (t == 1)
        s += '1';
      else {
        s += '-';
        x += 2;
      }
      x /= 3;
    }
    reverse(s.begin(), s.end());
    if (flag)
      for (int i = 0; i < s.size(); i++)
        if (s[i] == '-')
          s[i] = '1';
        else if (s[i] == '1')
          s[i] = '-';
    printf("%s\n", s.c_str());
  }
}