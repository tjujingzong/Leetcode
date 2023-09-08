#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, r, k;
  cin >> n >> r >> k;
  vector<int> graph[n + 1];
  for (int i = 0; i < r; i++) {
    int a, b;
    cin >> a >> b;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  int m;
  cin >> m;

  for (int i = 0; i < m; i++) {
    int a[n + 1];
    set<int> s;
    for (int j = 1; j <= n; j++) {
      cin >> a[j];
      s.insert(a[j]);
    }
    if (s.size() > k) {
      cout << "Error: Too many species." << endl;
    } else if (s.size() < k) {
      cout << "Error: Too few species." << endl;
    } else {
      bool flag = true;
      for (int j = 1; j <= n; j++) {
        if (!flag)
          break;
        for (int l = 0; l < graph[j].size(); l++) {
          if (a[j] == a[graph[j][l]]) {
            cout << "No" << endl;
            flag = false;
            break;
          }
        }
      }
      if (flag)
        cout << "Yes" << endl;
    }
  }
}