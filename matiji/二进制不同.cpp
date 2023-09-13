#include <bits/stdc++.h>
using namespace std;

int main() {
  string s;
  unordered_set<string> st;
  int n;
  while (cin >> s) {
    st.insert(s);
  }
  n = st.size();
  for (int i = 0; i < (1 << n); i++) {
    string s = "";
    for (int j = n - 1; j >= 0; j--) {
      s += (i >> j & 1) ? '1' : '0';
    }
    if (st.count(s) == 0) {
      cout << s << endl;
      break;
    }
  }
  return 0;
}