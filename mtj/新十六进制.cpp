#include <bits/stdc++.h>

using namespace std;

char d[] = "0123456789ABCDEF";
string s;
int cnt = 0;
string a[100005];

void dfs(int n) {
  a[cnt++] = s;
  for (int i = n + 1; i < 16; i++) {
    s.push_back(d[i]);
    dfs(i);
    s.pop_back();
  }
}
bool cmp(string a, string b) {
  if (a.size() != b.size())
    return a.size() < b.size();
  else
    return a < b;
}

int main() {
  dfs(0);
  a[0] = "0";
  string t;
  cin >> t;
  int ans = 1;
  if (t[0] == '-') {
    ans = -1;
    t.erase(0, 1);
  }
  while (t[0] == '0' && t.size() > 1) {
    t.erase(0, 1);
  }
  sort(a + 1, a + cnt, cmp);
  bool flag = false;
  for (int i = 0; i < cnt; i++) {
    if (a[i] == t) {
      ans = i * ans;
      flag = true;
      break;
    }
  }
  if (flag)
    cout << ans << endl;
  else
    cout << "error" << endl;
  return 0;
}