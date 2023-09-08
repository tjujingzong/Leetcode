#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n + 1);
  int cnt = 0;
  for (int j = 1; j <= n; j++)
    cin >> v[j];
  for (int j = 1; j <= n; j++) {
    for (int k = j + 1; k <= n; k++) {
      vector<int> lie;
      for (int i = 1; i <= n; i++) {
        if (v[i] < 0) {
          if (v[i] != -j && v[i] != -k)
            lie.push_back(i);
        } else {
          if (v[i] == j || v[i] == k)
            lie.push_back(i);
        }
      }
      if (lie.size() == 2) {
        int cnt = 0;
        for (int i : lie) {
          if (i == j || i == k)
            cnt++;
        }
        if (cnt != 1)
          continue;
        cout << j << " " << k << endl;
        return 0;
      }
    }
  }
  cout << "No Solution" << endl;
  return 0;
}