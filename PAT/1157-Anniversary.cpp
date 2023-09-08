#include <bits/stdc++.h>
using namespace std;

bool cmp(string a, string b) {
  if (a.substr(6, 4) != b.substr(6, 4))
    return a.substr(6, 4) < b.substr(6, 4);
  if (a.substr(10, 2) != b.substr(10, 2))
    return a.substr(10, 2) < b.substr(10, 2);
  return a.substr(12, 2) < b.substr(12, 2);
}
int main() {
  int n;
  cin >> n;
  unordered_map<string, int> m;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    m[s]++;
  }
  int cnt = 0;
  int mm;
  cin >> mm;
  string ans;
  string ans1;
  for (int i = 0; i < mm; i++) {
    string s;
    cin >> s;
    m[s]++;
    if (m[s] > 1) {
      cnt++;
      if (ans == "")
        ans = s;
      else if (cmp(s, ans))
        ans = s;
    }
    if (ans1 == "")
      ans1 = s;
    else if (cmp(s, ans1))
      ans1 = s;
  }
  cout << cnt << endl;
  if (cnt == 0)
    cout << ans1;
  else {
    cout << ans;
  }
}
