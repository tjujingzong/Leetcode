#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 7;
int n, ans[N], cnt;
string s[N];
char tmp[N];
struct TRIE {
  int nex[N][26], id, m[26][26], A[30], B[30];
  bool ed[N];
  void insert(string s) {  // ·插入字符串，p是节点号
    int p = 0, l = s.size();
    for (int i = 0; i < l; i++) {
      int c = s[i] - 'a';
      if (!nex[p][c])
        nex[p][c] = ++id;
      // ·如果没有，就添加结点
      p = nex[p][c];
    }
    ed[p] = 1;
  }
  bool check(string s) {
    memset(m, 0, sizeof(m));
    int p = 0, l = s.size();
    for (int i = 0; i < l; i++) {
      int c = s[i] - 'a';
      // 1.看有没有更短的前缀是已知字符串。p是当前扫的字符的节点的父节点
      if (ed[p])
        return false;
      // 2.看是否有兄弟间的关系矛盾I
      for (int j = 0; j < 26; j++)
        if (nex[p][j] && m[c][j] > 0 && j != c)
          return false;
      // 3.更新前序和后续的节点组合
      A[0] = B[0] = 0;
      for (int j = 0; j < 26; j++) {
        if (nex[p][j] && j != c) {
          m[c][j] = -1;
          m[j][c] = 1;
          for (int k = 0; k < 26; ++k) {
            if (m[c][k] == 1) {
              A[++A[0]] = k;
              m[j][k] = 1;
              m[k][j] = -1;
            }
            if (m[j][k] == -1) {
              B[++B[0]] = k;
              m[c][k] = -1;
              m[k][c] = 1;
            }
          }
        }
      }
      for (int j = 1; j <= A[0]; j++)
        for (int k = 1; k <= B[0]; k++) {
          m[A[j]][B[k]] = -1;
          m[B[k]][A[j]] = 1;
        }
      p = nex[p][c];
    }
    return true;
  }
} trie;

int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    trie.insert(s[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (trie.check(s[i])) {
      ans[++cnt] = i;
    }
  }
  cout << cnt << endl;
  for (int i = 1; i <= cnt; i++) {
    cout << s[ans[i]] << endl;
  }
  return 0;
}
