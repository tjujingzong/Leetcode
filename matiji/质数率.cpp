#include <bits/stdc++.h>

using namespace std;
bool isprime[100000005];
void init(int x) {
  memset(isprime, 1, sizeof(isprime));
  isprime[1] = 0;
  for (int i = 2; i <= x; i++) {
    if (isprime[i])

      for (int j = 2 * i; j <= x; j += i) {
        isprime[j] = false;
      }
  }
}

int main() {
  int n;
  cin >> n;
  init(n);
  int cnt = 0;
  for (int i = 2; i <= n; i++) {
    if (isprime[i])
      cnt++;
  }
  printf("%.3f", (double)cnt / n);
  return 0;
}