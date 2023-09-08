#include <bits/stdc++.h>
using namespace std;
struct node {
  string data;
  int left, right;
};
node tree[30];
void dfs(int i) {
  cout << '(';
  if (tree[i].left != -1 && tree[i].right != -1) {
    dfs(tree[i].left);
    dfs(tree[i].right);
    cout << tree[i].data << ')';
  } else if (tree[i].right != -1) {
    cout << tree[i].data;
    dfs(tree[i].right);
    cout << ')';
  } else {
    cout << tree[i].data << ')';
  }
}
int main() {
  int n;
  cin >> n;
  int root = 1;
  vector<bool> isRoot(n + 1, true);
  for (int i = 1; i <= n; i++) {
    cin >> tree[i].data >> tree[i].left >> tree[i].right;
    if (tree[i].left != -1)
      isRoot[tree[i].left] = false;
    if (tree[i].right != -1)
      isRoot[tree[i].right] = false;
  }
  while (!isRoot[root]) {
    root++;
  }
  dfs(root);
}