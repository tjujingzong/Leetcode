#include <bits/stdc++.h>

using namespace std;

int main() {
  string s;
  int k;
  int ans = 0;
  cin >> s >> k;
  int n = s.size();
  for (int i = 0; i < k; i++) {
    if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' ||
        s[i] == 'u') {
      ans++;
    }
  }
  int t = ans;
  for (int i = k; i < n; i++) {
    if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' ||
        s[i] == 'u') {
      t++;
    }
    if (s[i - k] == 'a' || s[i - k] == 'e' || s[i - k] == 'i' ||
        s[i - k] == 'o' || s[i - k] == 'u') {
      t--;
    }
    ans = max(ans, t);
  }
  cout << ans << endl;
  return 0;
}