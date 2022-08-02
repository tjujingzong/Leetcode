#include <bits/stdc++.h>

using namespace std;

int main()
{
  int m, n;
  cin >> n >> m;
  int a[m * n];
  for (int i = 0; i < m * n; i++)
    cin >> a[i];
  int k;
  cin >> k;
  int b[n * m];
  for (int i = 0; i < k; i++)
    b[i] = a[m * n - k + i];
  for (int i = k; i < m * n; i++)
    b[i] = a[i - k];
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
      cout << b[i * m + j] << " ";
    cout << endl;
  }
  return 0;
}