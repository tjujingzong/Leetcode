#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> v[n];
  while (m--) {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b);
  }
  int k;
  cin >> k;
  while (k--) {
    vector<int> color(n);
    set<int> s;
    for (int i = 0; i < n; i++) {
      cin >> color[i];
      s.insert(color[i]);
    }
    bool flag = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < v[i].size(); j++) {
        if (color[i] == color[v[i][j]]) {
          flag = false;
          break;
        }
      }
    }
    if (flag) {
      cout << s.size() << "-coloring" << endl;
    } else {
      cout << "No" << endl;
    }
  }
}