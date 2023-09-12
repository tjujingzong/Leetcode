#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> v1, v;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    string str;
    vector<int>::iterator it;
    cin >> str;
    if (str == "Push") {
      int x;
      cin >> x;
      v1.push_back(x);
      it = lower_bound(v.begin(), v.end(), x);
      v.insert(it, x);
    } else if (str == "Pop") {
      if (v1.size() == 0)
        cout << "Invalid" << endl;
      else {
        it = lower_bound(v.begin(), v.end(), v1[v1.size() - 1]);
        v.erase(it);
        cout << v1[v1.size() - 1] << endl;
        v1.pop_back();
      }
    } else {
      if (v1.size() == 0)
        cout << "Invalid" << endl;
      else {
        if (v.size() % 2)
          cout << v[v1.size() / 2] << endl;
        else
          cout << v[v1.size() / 2 - 1] << endl;
      }
    }
  }
  return 0;
}