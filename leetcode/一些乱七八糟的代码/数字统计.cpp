#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  cin >> n;
  int ans = 0;
  for (int i = 1; i < n; i++)
  {
    // 如果将i逆置后对i取余数等于0，那么ans++
    int temp = i;
    int rev = 0;
    while (temp)
    {
      rev = rev * 10 + temp % 10;
      temp /= 10;
    }
    if (rev % i == 0)
      ans++;
  }
  cout << ans << endl;
  return 0;
}