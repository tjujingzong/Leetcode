#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  set<int> s;
  while (n--) {
    int t;
    cin >> t;
    int sum = 0;
    while (t > 0) {
      sum += t % 10;
      t /= 10;
    }
    s.insert(sum);
  }
  cout << s.size() << endl;
  int cnt = 0;
  for (const int& i : s) {
    if (cnt == 0)
      cout << i;
    else
      cout << " " << i;
    cnt++;
  }
}