#include <bits/stdc++.h>
using namespace std;
int n;
void dfs(string s, int x) {
  // cout<<s<<endl;
  if (x == n)
    cout << s;
  else {
    string ans;
    for (int i = 0; i < s.size(); i++) {
      int j = 1;
      while (i + j < s.size() && s[i] == s[i + j]) {
        j++;
      }
      ans += s[i];
      ans += '0' + j;
      i = i + j - 1;
    }
    dfs(ans, x + 1);
  }
}
int main() {
  string d;
  cin >> d;
  cin >> n;
  dfs(d, 1);
}