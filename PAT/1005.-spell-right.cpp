#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  long long sum = 0;
  for (char c : s)
    sum += c - '0';
  string ans = to_string(sum);
  string num[] = {"zero", "one", "two",   "three", "four",
                  "five", "six", "seven", "eight", "nine"};
  for (int i = 0; i < ans.size(); i++) {
    if (i != 0)
      cout << " ";
    cout << num[ans[i] - '0'];
  }
}