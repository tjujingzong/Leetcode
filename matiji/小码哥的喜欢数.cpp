#include <bits/stdc++.h>

using namespace std;
bool isprime[10000005];
bool dislike(int x) {
  if (x % 7 == 0)
    return true;
  while (x > 0) {
    int t = x % 10;
    if (t == 7)
      return true;
    x /= 10;
  }
  return false;
}
void init() {
  memset(isprime, 1, sizeof(isprime));
  isprime[0] = 0;
  for (int i = 7; i <= 10000005; i++) {
    if (dislike(i) && isprime[i])
      for (int j = i; j <= 10000005; j += i) {
        isprime[j] = false;
      }
  }
}
int main() {
  init();
  int t;
  cin >> t;
  int x;
  while (t--) {
    scanf("%d", &x);
    if (isprime[x]) {
      int i = x + 1;
      while (!isprime[i])
        i++;
      printf("%d\n", i);
    } else
      printf("-1\n");
  }
  return 0;
}