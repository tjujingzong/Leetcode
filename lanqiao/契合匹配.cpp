#include <bits/stdc++.h>

using namespace std;
char findLeastOccurringChar(const string& s) {
  unordered_map<char, int> m;
  for (int i = 0; i < s.size(); i++) {
    m[s[i]]++;
  }
  char leastOccurringChar = 'z';
  int leastOccurringCharCount = INT_MAX;
  for (auto& it : m) {
    if (it.second < leastOccurringCharCount) {
      leastOccurringChar = it.first;
      leastOccurringCharCount = it.second;
    }
  }
  return leastOccurringChar;
}

int main() {
  int n;
  cin >> n;
  string s, t;
  cin >> s >> t;

  char leastOccurringChar = findLeastOccurringChar(s);

  vector<int> a1, a2;

  bool isbig = (leastOccurringChar >= 'A' && leastOccurringChar <= 'Z');
  int diff = isbig ? 'a' - 'A' : 'A' - 'a';
  for (int i = 0; i < n; i++) {
    if (s[i] == leastOccurringChar)
      a1.push_back(i);

    if ((t[i] - leastOccurringChar == diff) ||
        (t[i] + diff == leastOccurringChar))
      a2.push_back(i);
  }

  if (a1.size() != a2.size()) {
    cout << "No" << endl;
    return 0;
  }

  int ans = n + 1;
  int a1_size = a1.size();
  int a2_size = a2.size();

  for (int i = 0; i < a1_size; i++) {
    for (int j = 0; j < a2_size; j++) {
      bool is_possible = true;
      for (int k = 1; k < n; k++) {
        if (abs(s[(a1[i] + k) % n] - t[(a2[j] + k) % n]) != 32) {
          is_possible = false;
          break;
        }
      }
      if (is_possible) {
        ans = min(ans, min(abs(a1[i] - a2[j]), n - abs(a1[i] - a2[j])));
      }
    }
  }

  if (ans == n + 1) {
    cout << "No" << endl;
    return 0;
  }

  cout << "Yes" << endl;
  cout << ans << endl;

  return 0;
}
