#include <bits/stdc++.h>

using namespace std;
int f[20][20];
int main() {
  int n, r;
  cin >> n >> r;
  // 将n个球放在r个盒子里，每个盒子至少有一个球
  f[0][0] = 1;
  // 初始化状态，同时为使f[i - 1][j - 1] 有意义
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= r; j++) {
      if (j > i)
        break;
      // 当盒子数大于球数时，则会出现空盒子不符合题意
      f[i][j] = f[i - 1][j - 1] + f[i - 1][j] * j;
    }
  }
  int ans = f[n][r];
  for (int i = 1; i <= r; i++)
    ans = ans * i;
  cout << ans;
  return 0;
}