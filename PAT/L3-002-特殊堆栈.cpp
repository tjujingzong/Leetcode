#include <bits/stdc++.h>
using namespace std;
int getmid(vector<int> a) {
  sort(a.begin(), a.end());
  return a[(a.size() + 1) / 2 - 1];
}
int main() {
  vector<int> a;
  int n;
  cin >> n;
  int midx = 0;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    if (s == "Push") {
      int k;
      cin >> k;
      a.push_back(k);
    } else if (s == "Pop") {
      if (a.size() == 0) {
        cout << "Invalid" << endl;
      } else {
        cout << a[a.size() - 1] << endl;
        a.pop_back();
      }
    } else {
      if (a.size() == 0) {
        cout << "Invalid" << endl;
      } else {
        cout << getmid(a) << endl;
      }
    }
  }
}