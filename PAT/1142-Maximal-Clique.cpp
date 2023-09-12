#include <bits/stdc++.h>
using namespace std;
bool con[205][205];
vector<int> g[205];
int n, m;
bool iscli(vector<int>& cli) {
  for (int i = 0; i < cli.size(); i++) {
    for (int j = i + 1; j < cli.size(); j++) {
      if (!con[cli[i]][cli[j]]) {
        return false;
      }
    }
  }
  return true;
}

bool ismax(vector<int>& cli) {
  unordered_set<int> s;
  for (int& c : cli) {
    s.insert(c);
  }
  for (int i = 1; i <= n; i++) {
    if (s.find(i) != s.end())
      continue;
    bool flag = true;
    for (int& c : cli) {
      if (!con[i][c]) {
        flag = false;
        break;
      }
    }
    if (flag)
      return false;
  }
  return true;
}
int main() {
  cin >> n >> m;
  memset(con, 0, sizeof(con));
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    con[a][b] = true;
    con[b][a] = true;
  }

  int t;
  cin >> t;
  while (t--) {
    int k;
    cin >> k;
    vector<int> cli(k);
    for (int i = 0; i < k; i++) {
      int temp;
      cin >> temp;
      cli[i] = temp;
    }
    if (!iscli(cli)) {
      cout << "Not a Clique" << endl;
    } else if (!ismax(cli)) {
      cout << "Not Maximal" << endl;
    } else
      cout << "Yes" << endl;
  }
}