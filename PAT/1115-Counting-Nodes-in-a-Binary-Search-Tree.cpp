#include <bits/stdc++.h>
using namespace std;
int maxh = 0;
struct node {
  int val;
  node *l, *r;
  int h;
};

void build(node* rot, int x) {
  if (x <= rot->val) {
    if (rot->l == nullptr) {
      node* newr = new node();
      newr->val = x;
      newr->h = rot->h + 1;
      maxh = max(newr->h, maxh);
      rot->l = newr;
    } else
      build(rot->l, x);
  } else {
    if (rot->r == nullptr) {
      node* newr = new node();
      newr->val = x;
      newr->h = rot->h + 1;
      maxh = max(newr->h, maxh);
      rot->r = newr;
    } else
      build(rot->r, x);
  }
}
int n1 = 0, n2 = 0;
void dfs(node* rot) {
  if (rot == nullptr)
    return;
  if (rot->h == maxh)
    n1++;
  else if (rot->h == maxh - 1)
    n2++;
  dfs(rot->l);
  dfs(rot->r);
}

int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  node* root = new node;
  root->val = a[0];
  root->h = 0;
  cout << (root->l == nullptr) << endl;
  cout << (root->r == nullptr) << endl;
  for (int i = 1; i < n; i++) {
    build(root, a[i]);
  }
  dfs(root);
  printf("%d + %d = %d", n1, n2, n2 + n1);
}