#include <bits/stdc++.h>
using namespace std;
struct node {
  /* data */
  string add;
  string pre, next;
  int data;
};

int main() {
  string l1, l2;
  std::ios::sync_with_stdio(false);

  cin >> l1 >> l2;
  int n;
  unordered_map<string, node> m;
  cin >> n;
  for (int i = 0; i < n; i++) {
    node t;
    cin >> t.add >> t.data >> t.next;
    m[t.add] = t;
  }
  vector<node> v1, v2;
  while (l1 != "-1") {
    v1.push_back(m[l1]);
    l1 = m[l1].next;
  }
  while (l2 != "-1") {
    v2.push_back(m[l2]);
    l2 = m[l2].next;
  }
  if (v1.size() < v2.size())
    swap(v1, v2);  // v1 is longer
  int i = 0, j = v2.size() - 1;
  for (int i = 1; i < v1.size(); i += 2) {
    if (j >= 0) {
      m[v1[i].add].next = v2[j].add;
      if (i + 1 < v1.size())
        m[v2[j].add].next = v1[i + 1].add;
      j--;
    }
  }
  string s = v1[i].add;
  while (s != "-1") {
    printf("%s %d %s\n", m[s].add.c_str(), m[s].data, m[s].next.c_str());
    s = m[s].next;
  }
}