#include <bits/stdc++.h>
using namespace std;
int n1, n2, n3;
vector<int> a1, a2, a3;
int dis(int i, int j, int k) {
  return abs(a1[i] - a2[j]) + abs(a1[i] - a3[k]) + abs(a3[k] - a2[j]);
}
int main() {
  cin >> n1 >> n2 >> n3;
  int t;
  for (int i = 0; i < n1; i++) {
    cin >> t;
    a1.push_back(t);
  }
  for (int i = 0; i < n2; i++) {
    cin >> t;
    a2.push_back(t);
  }
  for (int i = 0; i < n3; i++) {
    cin >> t;
    a3.push_back(t);
  }
  sort(a1.begin(), a1.end());
  sort(a2.begin(), a2.end());
  sort(a3.begin(), a3.end());
  int ans = 400000;
  int i = a1.size() - 1, j = a2.size() - 1, k = a3.size() - 1;
  int a, b, c;
  while (i >= 0 && j >= 0 && k >= 0) {
    if (dis(i, j, k) < ans) {
      ans = dis(i, j, k);
      a = a1[i];
      b = a2[j];
      c = a3[k];
    }
    if (a1[i] >= a2[j] && a1[i] >= a3[k]) {
      i--;
    } else if (a2[j] >= a1[i] && a2[j] >= a3[k]) {
      j--;
    } else if (a3[k] >= a2[j] && a3[k] >= a1[i]) {
      k--;
    }
  }
  printf("MinD(%d, %d, %d) = %d", a, b, c, ans);
}