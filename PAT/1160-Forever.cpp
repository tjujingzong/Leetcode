#include <bits/stdc++.h>
using namespace std;
struct fo {
  int n;
  long long a;
};
bool cmp(fo a, fo b) {
  if (a.n == b.n)
    return a.a < b.a;
  return a.n < b.n;
}

int k, m;

int getsum(int x) {
  int sum = 0;
  while (x) {
    sum += x % 10;
    x /= 10;
  }
  return sum;
}
void dfs(long long num, int sum, int cnt, vector<fo>& v) {
  if (cnt == k) {
    if (sum == m) {
      fo f;
      f.n = getsum(num + 1);
      f.a = num;
      if (__gcd(f.n, m) > 2)
        v.push_back(f);
    }
    return;
  }
  if (sum > m - 9)
    return;
  if (cnt == k - 1) {
    dfs(num * 10 + 9, sum + 9, cnt + 1, v);
  } else {
    for (int i = 0; i <= 9; i++) {
      dfs(num * 10 + i, sum + i, cnt + 1, v);
    }
  }
}

int main() {
  int t;
  cin >> t;
  int t2 = t;
  while (t-- > 0) {
    vector<fo> v;
    cin >> k >> m;
    for (int i = 1; i <= 9; i++) {
      dfs(i, i, 1, v);
    }
    sort(v.begin(), v.end(), cmp);

    printf("Case %d\n", t2 - t);
    for (int i = 0; i < v.size(); i++) {
      printf("%d %d\n", v[i].n, v[i].a);
    }
    if (v.size() == 0)
      printf("No Solution\n");
  }
}
