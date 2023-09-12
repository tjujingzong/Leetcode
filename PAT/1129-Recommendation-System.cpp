#include <bits/stdc++.h>
using namespace std;
unordered_map<int, int> mp;

int main() {
  int n, k;
  cin >> n >> k;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    int q;
    cin >> q;
    if (i > 0) {
      cout << q << ":";
    }
    for (int j = 0; j < min(k, (int)v.size()); j++) {
      cout << " " << v[j];
    }
    if (i > 0)
      cout << endl;
    if (v.size() < k && find(v.begin(), v.end(), q) == v.end())
      v.push_back(q);
    mp[q]++;
    if (v.size() >= k) {
      if (mp[q] < mp[v[k - 1]])
        continue;
      if (mp[q] == mp[v[k - 1]] && v[k - 1] < q)
        continue;
      if (find(v.begin(), v.end(), q) == v.end()) {
        v.push_back(q);
      }
    }
    sort(v.begin(), v.end(), [](int& a, int& b) {
      if (mp[a] != mp[b])
        return mp[a] > mp[b];
      return a < b;
    });
    if (v.size() > k) {
      for (int j = 0; j < v.size() - k; j++) {
        v.pop_back();
      }
    }
  }
}