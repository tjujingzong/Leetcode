#include <bits/stdc++.h>
using namespace std;
vector<int> s;
void tostrd(int n, int d) {
  string ans = "";
  while (n > 0) {
    s.push_back(n % d);
    n /= d;
  }
  return;
}
bool ispali() {
  for (int i = 0; i < s.size() / 2; i++) {
    if (s[i] != s[s.size() - 1 - i]) {
      return false;
    }
  }
  return true;
}

int main() {
  int n, d;
  cin >> n >> d;
  tostrd(n, d);
  if (ispali()) {
    cout << "Yes" << endl;
  } else
    cout << "No" << endl;
  for (int i = 0; i < s.size(); i++) {
    cout << s[s.size() - 1 - i];
    if (i != s.size() - 1) {
      cout << " ";
    }
  }
}