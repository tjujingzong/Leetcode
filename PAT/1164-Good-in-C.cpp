#include <bits/stdc++.h>
using namespace std;
char c[26][7][5];
void prt(string s) {
  for (int i = 0; i < 7; i++) {
    for (int j = 0; j < s.length(); j++) {
      int idx = s[j] - 'A';
      for (int k = 0; k < 5; k++) {
        printf("%c", c[idx][i][k]);
      }
      if (j + 1 < s.length())
        printf(" ");
    }
    printf("\n");
  }
}
int main() {
  for (int i = 0; i < 26; i++) {
    for (int j = 0; j < 7; j++) {
      for (int k = 0; k < 5; k++) {
        cin >> c[i][j][k];
      }
    }
  }
  string s;

  cin.ignore();
  getline(cin, s);
  s += " ";
  int start = 0;
  vector<string> v;
  for (int i = 0; i < s.length(); i++) {
    if (!isalpha(s[i])) {
      if (start != i) {
        string t = s.substr(start, i - start);
        v.push_back(t);
      }
      start = i + 1;
      continue;
    }
  }
  for (int i = 0; i < v.size(); i++) {
    prt(v[i]);
    if (i + 1 < v.size())
      printf("\n");
  }
}