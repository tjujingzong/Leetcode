#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, money;
  cin >> n >> money;
  int goods[n];
  int coupons[n];
  for (int i = 0; i < n; i++) {
    cin >> goods[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> coupons[i];
  }
  vector<int> a;
  sort(goods, goods + n);
  sort(coupons, coupons + n, [](int& a, int& b) { return a > b; });
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      a.push_back(goods[i] - coupons[j]);
    }
    if (a.size() > 8000000)//防止超内存 偷鸡
      break;
  }
  int i = 0;
  sort(a.begin(), a.end());
  while (i < a.size()) {
    if (money < a[i])
      break;
    money -= a[i];
    i++;
  }
  cout << i << " " << money;
}