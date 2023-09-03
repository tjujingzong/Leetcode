#include <iostream>
#include <map>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
  int n;
  cin >> n;
  cin.ignore();  // Ignore the newline character after reading n

  string s;
  getline(cin, s);

  unordered_map<string, int> m;  // Using unordered_map for better performance
  string sub = s.substr(0, n);
  m[sub] = 1;

  int maxCount = 1;
  string ans = sub;

  for (int i = n; i < (int)s.size(); i++) {
    sub = sub.substr(1) + s[i];  // Update sliding window
    if (m.find(sub) == m.end()) {
      m[sub] = 1;
    } else {
      m[sub]++;
      if (m[sub] > maxCount) {
        maxCount = m[sub];
        ans = sub;
      } else if (m[sub] == maxCount && sub < ans) {
        ans = sub;
      }
    }
  }

  cout << ans << " " << maxCount << endl;
  return 0;
}
