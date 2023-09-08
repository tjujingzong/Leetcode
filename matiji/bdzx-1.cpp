#include <bits/stdc++.h>

using namespace std;
bool IsPrime(long long int num)
{
  if (num < 2)
    return false;
  for (long long int i = 2; i * i < num; ++i)
  {
    if (num % i == 0)
      return false;
  }
  return true;
}

int main()
{
  int t;
  cin >> t;
  while (t--)
  {
    long long int n;
    cin >> n;
    long long int num = sqrt(n);
    if (num * num != n)
    {
      cout << "NO" << endl;
      continue;
    }
    if (IsPrime(num))
    {
      cout << "YES" << endl;
      continue;
    }
    cout << "NO" << endl;
  }
  return 0;
}