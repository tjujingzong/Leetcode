#include <bits/stdc++.h>

using namespace std;
int a, b, c, d;
long f(int x, int y)
{
  if (x >= 2)
    return f(x - 1, f(x - 1, y)) % 10;
  return c * y + d;
}
int main()
{
  cin >> a >> b >> c >> d;
  cout << f(a, b) % 10 << endl;
  return 0;
}