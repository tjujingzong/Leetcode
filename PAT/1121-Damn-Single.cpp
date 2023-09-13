#include <bits/stdc++.h>
using namespace std;
int pr[100005];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < 100005; i++) {
    pr[i] = -1;
  }
  while (n--) {
    int a, b;
    cin >> a >> b;
    pr[a] = b;
    pr[b] = a;
  }
  vector<int> v;
  int t;
  cin >> t;
  while (t--) {
    int temp;
    cin >> temp;
    v.push_back(temp);
  }
  vector<int> v2;
  for (int& i : v) {
    if (pr[i] == -1) {
      v2.push_back(i);
      continue;
    }
    if (find(v.begin(), v.end(), pr[i]) == v.end()) {
      v2.push_back(i);
    }
  }

  sort(v2.begin(), v2.end());
  printf("%d\n", v2.size());
  if (v2.size() > 0)
    printf("%05d", v2[0]);
  for (int i = 1; i < v2.size(); i++) {
    printf(" %05d", v2[i]);
  }
}