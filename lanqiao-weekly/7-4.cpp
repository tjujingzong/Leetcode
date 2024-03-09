#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> s;
  for (int i = 0; i <= 30; ++i) {
    s.insert(1 << i);  // 1 << i 是 2 的 i 次幂
  }
  int n;
  cin >> n;
  map<int, int> m;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    m[a]++;
  }
  long long int ans = 0;
  for (auto i : m) {
    if (i.second >= 2 && s.count(i.first * 2)) {
      ans += (i.second * (i.second - 1)) / 2;
      continue;
    }
    for (int j : s) {
      auto it = m.find(j - i.first);  // 使用find方法检查元素是否存在
      if (it != m.end() && j - i.first > i.first) {  // 如果找到且满足条件
        ans += i.second * it->second;  // 使用迭代器访问值，避免创建新元素
      }
    }
  }
  cout << ans;
}