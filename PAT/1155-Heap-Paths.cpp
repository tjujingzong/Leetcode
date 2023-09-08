#include <bits/stdc++.h>
using namespace std;
bool flag1 = true;
bool flag2 = true;
int n;
int a[1005];
void dfs(int i, vector<int>& v) {
  if (v.size() > 1) {
    if (v[v.size() - 1] < v[v.size() - 2])
      flag1 = false;
    if (v[v.size() - 1] > v[v.size() - 2])
      flag2 = false;
  }
  v.push_back(a[i]);
  if (2 * i + 1 <= n) {
    dfs(2 * i + 1, v);
    v.pop_back();
  }
  if (2 * i <= n) {
    dfs(2 * i, v);
    v.pop_back();
  }

  if (2 * i > n && 2 * i + 1 > n) {
    for (int i = 0; i < v.size(); i++) {
      cout << v[i];
      if (i != v.size() - 1)
        cout << " ";
    }
    cout << endl;
    return;
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  vector<int> v;
  dfs(1, v);
  if (flag1)
    cout << "Min Heap" << endl;
  else if (flag2)
    cout << "Max Heap" << endl;
  else
    cout << "Not Heap" << endl;
}