#include <bits/stdc++.h>
using namespace std;
struct edge {
  int s, t;
};

int main() {
  int n, m;
  cin >> n >> m;
  vector<edge> v;
  while (m--) {
    edge e;
    cin >> e.s >> e.t;
    v.push_back(e);
  }
  int t;
  cin >> t;
  while (t--) {
    int k;
    cin >> k;
    unordered_set<int> s;
    while (k--) {
      int temp;
      cin >> temp;
      s.insert(temp);
    }
    bool flag = true;
    for (edge& e : v) {
      if (s.find(e.s) == s.end() && s.find(e.t) == s.end()) {
        flag = false;
        break;
      }
    }
    if (flag)
      cout << "Yes" << endl;
    else
      cout << "No" << endl;
  }
}
