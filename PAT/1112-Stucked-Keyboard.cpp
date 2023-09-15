#include <bits/stdc++.h>
using namespace std;

int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  bool isk[50];
  memset(isk, 1, sizeof(isk));
  for (int i = 0; i < s.size(); i++) {
    int t;
    if (isalpha(s[i])) {
      t = s[i] - 'a';
    } else if (isdigit(s[i])) {
      t = s[i] - '0' + 30;
    } else
      t = 45;
    if (!isk[k])
      continue;
    int cnt = 0;
    for (int j = i + 1; j < min((int)s.size(), i + k); j++) {
      if (s[j] != s[i])
        break;
      cnt++;
    }
    if (cnt == k - 1) {
      i += (k - 1);
    } else {
      if (isalpha(s[i])) {
        isk[s[i] - 'a'] = 0;
      } else if (isdigit(s[i])) {
        isk[s[i] - '0' + 30] = 0;
      } else
        isk[45] = 0;
    }
  }
  vector<char> v;
  for (int i = 0; i < s.size(); i++) {
    if (find(v.begin(), v.end(), s[i]) != v.end())
      continue;
    int t;
    if (isalpha(s[i])) {
      t = s[i] - 'a';
    } else if (isdigit(s[i])) {
      t = s[i] - '0' + 30;
    } else
      t = 45;
    if (isk[t])
      v.push_back(s[i]);
  }
  string ans = "";
  for (int i = 0; i < s.size(); i++) {
    ans += s[i];
    if (find(v.begin(), v.end(), s[i]) != v.end()) {
      i += k - 1;
    }
  }
  for (char& c : v) {
    cout << c;
  }
  cout << endl;
  cout << ans;
}