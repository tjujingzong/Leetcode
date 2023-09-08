#include <bits/stdc++.h>
using namespace std;
int a[5000005];
int n, p, s, e, sc;
int main()
{
  scanf("%d", &n);
  scanf("%d", &p);
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]);
  for (int j = 0; j < p; j++)
  {
    scanf("%d", &s);
    scanf("%d", &e);
    scanf("%d", &sc);
    for (int i = s; i <= e; i++)
      a[i] += sc;
  }
  int minsc = a[1];
  for (int i = 1; i <= n; i++)
    if (minsc > a[i])
      minsc = a[i];
  printf("%d\n", minsc);
  return 0;
}