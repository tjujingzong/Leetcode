#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  while (n--) {
    string s;
    cin >> s;
    string s1 = s.substr(s.size() / 2);
    string s2 = s.substr(0, s.size() / 2);
    int z = stoi(s);
    int n1 = stoi(s1);
    int n2 = stoi(s2);
    if (n1 * n2 == 0) {
      cout << "No" << endl;
      continue;
    }
    if (z % (n1 * n2) == 0) {
      cout << "Yes" << endl;
    } else {
      cout << "No" << endl;
    }
  }
}