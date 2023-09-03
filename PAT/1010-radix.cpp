#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  int tag, radix;
  cin >> s1 >> s2 >> tag >> radix;
  if (tag == 2)
    swap(s1, s2);
  long long n1 = 0;
  for (int i = 0; i < s1.size(); i++) {
    n1 *= radix;
    if (s1[i] >= '0' && s1[i] <= '9')
      n1 += s1[i] - '0';
    else
      n1 += s1[i] - 'a' + 10;
  }
  int maxd = 0;
  for (int i = 0; i < s2.size(); i++) {
    if (s2[i] >= '0' && s2[i] <= '9')
      maxd = max(maxd, s2[i] - '0');
    else
      maxd = max(maxd, s2[i] - 'a' + 10);
  }
  long long l = maxd + 1, r = max(l, n1) + 1;
  for (int mid = l; mid <= r; mid++) {
    long long mid = (l + r) / 2;
    long long n2 = 0;
    for (int i = 0; i < s2.size(); i++) {
      n2 *= mid;
      if (s2[i] >= '0' && s2[i] <= '9')
        n2 += s2[i] - '0';
      else
        n2 += s2[i] - 'a' + 10;
    }
    if (n2 == n1) {
      cout << mid << endl;
      return 0;
    } else if (n2 > n1 || n2 < 0)
      r = mid;
    else
      l = mid + 1;
  }
  cout << "Impossible" << endl;
  return 0;
}