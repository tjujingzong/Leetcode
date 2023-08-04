#include <bits/stdc++.h>
using namespace std;
#define ULL unsigned long long
const int P = 131;
const int N = 5e5 + 7;
ULL p[N], h1[N], h2[N];
// p[i]=P个i,h1[i]is [1~i]的hash值,h2[i]=s [n~i]的hash值，
char s[N];
int len, ans[N];
void init(int n) {  // 预处理hash函数的前缀和
  p[0] = 1;
  for (int i = 1; i <= n; i++) {
    p[i] = p[i - 1] * P;
    h1[i] = h1[i - 1] * P + s[i];
    h2[n - i + 1] = h2[n - i + 2] * P + s[n - i + 1];
  }
}
int main() {
  cin >> s + 1;
  int len = strlen(s + 1);
  init(len);
  ans[1] = 1;
  cout << 1 << " ";
  for (int i = 2; i <= len; i++) {
    if (h1[i] == h2[1] - h2[i + 1] * p[i])
      ans[i] = ans[i >> 1] + 1;
    cout << ans[i] << " ";
  }
  return 0;
}
