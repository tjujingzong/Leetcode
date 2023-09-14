#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    v.push_back(tmp);
  }
  sort(v.begin(), v.end());
  for (int i = n; i > 0; i--) {
    if (v[n - i] > i) {
      cout << i;
      return 0;
    }
  }
  cout << 0;
}