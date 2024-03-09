#include <iostream>
using namespace std;
int nums[10][7] = {{1, 1, 1, 1, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0},
                   {1, 1, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 0, 0, 1},
                   {0, 1, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 0, 1, 1},
                   {1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0},
                   {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1}};

int main() {
  // 请在此输入您的代码
  string s, t;
  cin >> s;
  cin >> t;
  int ans = 0;
  for (int i = 0; i < s.size(); i++) {
    int a = s[i] - '0';
    int b = t[i] - '0';
    for (int j = 0; j < 7; j++) {
      if (nums[a][j] != nums[b][j]) {
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}