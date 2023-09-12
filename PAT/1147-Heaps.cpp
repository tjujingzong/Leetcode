#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[1005];
stack<int> s;

void dfs(int x) {
  if (x > n)
    return;
  s.push(a[x]);
  dfs(2 * x + 1);
  dfs(2 * x);
}
int main() {
  cin >> m >> n;
  while (m--) {
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if (a[1] > a[2]) {
      bool flag = true;
      for (int i = 1; i <= n; i++) {
        if (2 * i <= n) {
          if (a[2 * i] > a[i]) {
            flag = false;
            break;
          }
        } else
          break;
        if (2 * i + 1 <= n) {
          if (a[2 * i + 1] > a[i]) {
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        cout << "Max Heap" << endl;
      } else
        cout << "Not Heap" << endl;
      ;
    } else {
      bool flag = true;
      for (int i = 1; i <= n; i++) {
        if (2 * i <= n) {
          if (a[2 * i] < a[i]) {
            flag = false;
            break;
          }
        } else
          break;
        if (2 * i + 1 <= n) {
          if (a[2 * i + 1] < a[i]) {
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        cout << "Min Heap" << endl;
      } else
        cout << "Not Heap" << endl;
    }
    dfs(1);
    while (!s.empty()) {
      int t = s.top();
      s.pop();
      cout << t;
      if (!s.empty()) {
        cout << " ";
      }
    }
    cout << endl;
  }
}