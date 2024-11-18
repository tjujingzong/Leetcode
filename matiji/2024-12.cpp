#include <bits/stdc++.h>
using namespace std;

int n, a[1000005], b[1000005];
int cul(int* a, int* b, int f) {
  int ai = 1, aj = n, bi = 1, bj = n;
  int resa = 0, resb = 0;
  while (ai <= aj) {
    if (a[aj] > b[bj]) {
      resa += 2;
      aj--;
      bj--;
    } else if (a[ai] > b[bi]) {
      resa += 2;
      ai++;
      bi++;
    } else {
      if (a[ai] == b[bj]) {
        resa++;
        resb++;
        ai++;
        bj--;
      } else {
        ai++;
        bj--;
        resb += 2;
      }
    }
  }
  if (f)
    return resa;
  else
    return resb;
}

int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &b[i]);
  }
  sort(a + 1, a + 1 + n);
  sort(b + 1, b + 1 + n);
  printf("%d %d\n", cul(a, b, 1), cul(b, a, 0));
}
