#include <iostream>
using namespace std;
int main() {
  // 请在此输入您的代码
  int n;
  cin >> n;
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;
    int ans = 1;
    for (int i = 0; i < s.size(); i++) {
      ans *= 2;
      if (s[i] == 'L') {
        ans--;
      }
    }
    cout << ans << endl;
  }
  return 0;
}