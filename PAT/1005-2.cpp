#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long ull;

const int N = 1050000;
const int P = 131;

ull h[N], p[N];
string s;

void init(int len) {
  p[0] = 1;
  for (int i = 1; i <= len; i++) {
    h[i] = h[i - 1] * P + s[i];
    p[i] = p[i - 1] * P;
  }
}

ull get(int l, int r) {
  return h[r] - h[l - 1] * p[r - l + 1];
}

int main() {
  int n;
  cin >> n;
  getchar();
  getline(cin, s);
  int len = (int)s.size();
  s = " " + s;
  init(len);
  unordered_map<ull, int> mp;
  int pos;
  int ans2 = -1;
  for (int i = 1; i <= len - n + 1; i++) {
    ull tmp = get(i, i + n - 1);
    mp[tmp]++;
    if (mp[tmp] > ans2) {
      pos = i, ans2 = mp[tmp];
    } else if (mp[tmp] == ans2) {
      int l = 0, r = n;
      while (l < r) {
        int mid = (l + r + 1) >> 1;
        if (get(pos, pos + mid - 1) == get(i, i + mid - 1))
          l = mid;
        else
          r = mid - 1;
      }
      if (l == n)
        continue;
      if (s[pos + l] > s[i + l])
        pos = i;
    }
  }
  cout << s.substr(pos, n) << " " << ans2;
  return 0;
}