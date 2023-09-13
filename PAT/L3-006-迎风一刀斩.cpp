#include <bits/stdc++.h>
#define pb(x) push_back(x)
using namespace std;
int flag;
vector<int> v[2], n, len;
void deal(vector<int>& a, vector<int>& b, int id) {
  int sz = a.size();
  set<int> st;
  for (int i = 0; i < sz; i++)
    if (a[i] != a[(i + 1) % sz] && b[i] != b[(i + 1) % sz]) {
      st.insert((i + 1) % sz);
      st.insert(i);
      if (sz == 4)
        len.pb(abs(a[(i + 2) % 4] - a[(i + 3) % 4]) +
               abs(b[(i + 2) % 4] - b[(i + 3) % 4]));  // 存储直角腰的长度
    }
  if (st.size() == 0) {  // 是矩形
    v[id].pb(abs(a[2] - a[0]));
    v[id].pb(abs(b[2] - b[0]));
    flag++;
  } else
    for (int i : st)
      v[id].pb(a[i]), v[id].pb(b[i]);  // 存储斜边
}
void solve() {
  if (n[0] < 6 && n[1] < 6 && n[0] + n[1] < 9) {
    if (flag == 2) {
      int a = v[0][0], b = v[0][1], c = v[1][0], d = v[1][1];
      if (a == c || a == d || b == c || b == d) {
        puts("YES");
        return;
      }
    } else if (flag == 0) {
      if (v[0].size() == 4 && v[1].size() == 4) {
        if (n[0] == 4 && n[1] == 4 && len[0] != len[1]) {
          puts("NO");
          return;
        }  // 特判直角腰
        int a = abs(v[0][2] - v[0][0]), b = abs(v[0][3] - v[0][1]);
        if (a > b)
          swap(a, b);
        int c = abs(v[1][2] - v[1][0]), d = abs(v[1][3] - v[1][1]);
        if (c > d)
          swap(c, d);
        if (a == c && b == d) {
          puts("YES");
          return;
        }
      }
    }
  }
  puts("NO");
}
int main() {
  //	freopen("Sakura.txt","r",stdin);
  int kase;
  cin >> kase;
  while (kase--) {
    flag = 0;
    n.clear();
    len.clear();
    for (int i = 0; i < 2; i++) {
      v[i].clear();
      int k;
      cin >> k;
      n.pb(k);
      vector<int> a(k), b(k);
      for (int i = 0; i < k; i++)
        cin >> a[i] >> b[i];
      deal(a, b, i);
    }
    solve();
  }
}
