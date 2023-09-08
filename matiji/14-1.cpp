#include <bits/stdc++.h>

using namespace std;

int main()
{
  long long int n, m, s;
  cin >> n >> m >> s;
  long long int maxsize = ((m - 1) / s + 1) * ((n - 1) / s + 1);
  long long int times = (1 + (n - 1) % s) * (1 + (m - 1) % s);
  cout << maxsize * times << endl;
}