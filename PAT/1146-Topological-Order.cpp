#include <bits/stdc++.h>
using namespace std;
vector<int> g[1005];
int n, m;
bool istopo(vector<int> in, vector<int> a) {
  for (int i = 0; i < n; i++) {
    if (in[a[i]] != 0)
      return false;
    for (int next : g[a[i]]) {
      in[next]--;
    }
  }
  return true;
}
int main() {
  cin >> n >> m;
  vector<int> in(n + 1);
  for (int i = 0; i < m; i++) {
    int s, t;
    cin >> s >> t;
    g[s].push_back(t);
    in[t]++;
  }
  int k;
  cin >> k;
  vector<int> ans;
  for (int i = 0; i < k; i++) {
    vector<int> a(n);
    for (int j = 0; j < n; j++) {
      cin >> a[j];
    }
    if (!istopo(in, a)) {
      ans.push_back(i);
    }
    // for (int j = 1; j <= n; j++) {
    //   cout << in[j] << " ";
    // }
    // cout << endl;
  }
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i];
    if (i != ans.size() - 1)
      cout << " ";
  }
}