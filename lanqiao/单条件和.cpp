#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  unsigned ans;
  scanf("%u", &ans);
  for (int i = 2; i <= n; i++) {
    unsigned x;
    scanf("%u", &x);
    ans = ~ans | x;
  }
  printf("%u\n", ans);
}