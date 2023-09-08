#include <bits/stdc++.h>
using namespace std;
bool isex[100007];
bool isdiff[100007];
int main() {
  int a, b;
  cin >> a >> b;
  memset(isex, false, sizeof(isex));
  memset(isdiff, false, sizeof(isdiff));
  unordered_set<int> ex;
  unordered_set<int> diff;
  ex.insert(a);
  ex.insert(b);
  diff.insert(abs(a - b));
  isex[a] = true;
  isex[b] = true;
  isdiff[abs(a - b)] = true;
  int n, m;
  cin >> n >> m;
  int arr[n][m];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> arr[i][j];
    }
  }
  bool isout[m];
  memset(isout, false, sizeof(isout));
  for (int j = 0; j < m; j++) {
    vector<int> v1;
    for (int i = 0; i < n; i++) {
      if (isout[i])
        continue;
      if (isex[arr[i][j]] || !isdiff[arr[i][j]]) {
        v1.push_back(i);
        isout[i] = true;
      } else {
        for (int ii : ex) {
          diff.insert(abs(ii - arr[i][j]));
          isdiff[abs(ii - arr[i][j])] = true;
        }
        ex.insert(arr[i][j]);
        isex[arr[i][j]] = true;
      }
    }
    if (v1.size() > 0) {
      for (int i = 0; i < v1.size(); i++) {
        cout << "Round #" << j + 1 << ": ";
        cout << v1[i] + 1 << " ";
        cout << "is out." << endl;
      }
    }
  }
  vector<int> v2;
  for (int i = 0; i < n; i++) {
    if (!isout[i])
      v2.push_back(i);
  }
  if (v2.size() > 0) {
    cout << "Winner(s): ";
    for (int i = 0; i < v2.size(); i++) {
      cout << v2[i] + 1;
      if (i != v2.size() - 1)
        cout << " ";
    }
    cout << endl;
  } else {
    cout << "No winner." << endl;
  }
}