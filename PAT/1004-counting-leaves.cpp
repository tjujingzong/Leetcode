#include <bits/stdc++.h>
using namespace std;
struct node {
  string parent;
  vector<string> children;
  int level;
};

int main() {
  int n, m;
  cin >> n >> m;
  unordered_map<string, node> tree;
  for (int i = 0; i < m; i++) {
    string id, parent;
    cin >> id;
    if (tree.find(id) == tree.end())
      tree[id] = node();
    int k;
    cin >> k;
    for (int j = 0; j < k; j++) {
      string child;
      cin >> child;
      if (tree.find(child) == tree.end())
        tree[child] = node();
      tree[child].parent = id;
      tree[id].children.push_back(child);
    }
  }
  queue<node> q;
  q.push(tree["01"]);
  vector<int> cnt(n + 5, 0);
  int maxlevel = 0;
  while (!q.empty()) {
    node cur = q.front();
    q.pop();
    maxlevel = max(maxlevel, cur.level);
    if (cur.children.size() == 0)
      cnt[cur.level]++;
    for (auto& child : cur.children) {
      tree[child].level = cur.level + 1;
      q.push(tree[child]);
    }
  }
  for (int i = 0; i <= maxlevel; i++) {
    if (i != 0)
      cout << " ";
    cout << cnt[i];
  }
}