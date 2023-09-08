#include <bits/stdc++.h>
using namespace std;
vector<int> v[100005];

int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b);
  }
  for (int i = 0; i < m; i++) {
    int k;
    cin >> k;
    unordered_set<int> s;
    for (int j = 0; j < k; j++) {
      int t;
      cin >> t;
      s.insert(t);
    }
    bool flag = true;
    for (int num : s) {
      for (int j : v[num]) {
        if (s.find(j) != s.end()) {
          flag = false;
          cout << "No" << endl;
          break;
        }
      }
      if (!flag)
        break;
    }
    if (flag)
      cout << "Yes" << endl;
  }
}