#include <bits/stdc++.h>

using namespace std;

int main() {
  string s;
  getline(cin, s);
  int ans = 0;
  int l = 0, r = 0;
  int n = s.size();
  unordered_map<char, int> mp;
  while (r < n) {
    if (mp.count(s[r]) && mp[s[r]] >= l) {
      l = mp[s[r]] + 1;
    }
    mp[s[r]] = r;
    ans = max(ans, r - l + 1);
    r++;
  }
  cout << ans << endl;
  return 0;
}