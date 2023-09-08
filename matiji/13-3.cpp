#include <bits/stdc++.h>

using namespace std;
typedef long long LL;
const LL maxa = 1e10 + 10;
LL euler_deall(LL n)
{
  LL res = n;
  for (LL i = 2; i * i <= n; i++)
  {
    if (n % i == 0)
    {
      res = res / i * (i - 1);
      for (; n % i == 0; n /= i)
        ;
    }
  }
  if (n != 1)
    res = res / n * (n - 1);
  return res;
}
int main()
{
  LL n;
  scanf("%lld", &n);
  printf("%lld\n", euler_deall(n));
}
