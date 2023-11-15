#include <bits/stdc++.h>

using namespace std;
int n, m;
void dfs(int x, vector<int> a) {
  if (a.size() == m) {
    for (int i = 0; i < a.size(); i++) {
      cout << a[i] << " ";
    }
    cout << endl;
    return;
  }
  for (int i = x + 1; i <= n; i++) {
    a.push_back(i);
    dfs(i, a);
    a.pop_back();
  }
}
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n - m + 1; i++) {
    vector<int> a;
    a.push_back(i);
    dfs(i, a);
    a.pop_back();
  }
  return 0;
}