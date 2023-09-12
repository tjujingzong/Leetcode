#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, g, f;
  cin >> m >> g >> f;
  vector<string> v;
  for (int i = 0; i < m; i++) {
    string ss;
    cin >> ss;
    v.push_back(ss);
  }
  if (f > m) {
    cout << "Keep going...";
  } else {
    set<string> s;
    int p = f - 1;
    while (p < v.size()) {
      if (s.find(v[p]) == s.end()) {
        cout << v[p] << endl;
        s.insert(v[p]);
        p += g;
      } else
        p++;
    }
  }
}