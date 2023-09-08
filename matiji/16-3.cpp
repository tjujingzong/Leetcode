#include <bits/stdc++.h>

using namespace std;

int main()
{
  map<int, int> a;
  int n;
  cin >> n;
  long long int ans = 0;
  int t;
  int index;
  set<int> s;
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &index);
    scanf("%d", &t);
    s.insert(index);
    if (t > a[index])
      a[index] = t;
    ans += t;
  }
  for (int i : s)
    ans -= a[i];
  cout << ans;
  return 0;
}