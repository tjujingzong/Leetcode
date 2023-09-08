#include <bits/stdc++.h>
using namespace std;
struct node {
  int data;
  node *lchild, *rchild;
  node* fa;
};
vector<int> pre;
vector<int> in;
unordered_map<int, node*> mp;
node* buildtree(int inl, int inr, int prel, int prer) {
  if (inl > inr) {
    return NULL;
  }
  node* root = new node;
  root->data = pre[prel];
  int k;
  for (int i = inl; i <= inr; i++) {
    if (in[i] == pre[prel]) {
      k = i;
      break;
    }
  }
  int numleft = k - inl;
  root->lchild = buildtree(inl, k - 1, prel + 1, prel + numleft);
  root->rchild = buildtree(k + 1, inr, prel + numleft + 1, prer);
  return root;
}

void dfs(node* root) {
  mp[root->data] = root;
  if (root->lchild != NULL) {
    root->lchild->fa = root;
    dfs(root->lchild);
  }
  if (root->rchild != NULL) {
    root->rchild->fa = root;
    dfs(root->rchild);
  }
}

int main() {
  int m, n;
  cin >> m >> n;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    in.push_back(temp);
  }
  unordered_set<int> s;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    pre.push_back(temp);
    s.insert(temp);
  }
  node* root = buildtree(0, n - 1, 0, n - 1);
  dfs(root);
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    vector<int> va, vb;
    if (s.find(a) == s.end() && s.find(b) == s.end()) {
      printf("ERROR: %d and %d are not found.\n", a, b);
      continue;
    }
    if (s.find(a) == s.end()) {
      printf("ERROR: %d is not found.\n", a);
      continue;
    }
    if (s.find(b) == s.end()) {
      printf("ERROR: %d is not found.\n", b);
      continue;
    }
    node* na = mp[a];
    node* nb = mp[b];
    while (na != NULL) {
      va.push_back(na->data);
      na = na->fa;
    }
    while (nb != NULL) {
      vb.push_back(nb->data);
      nb = nb->fa;
    }
    if (find(va.begin(), va.end(), b) != va.end()) {
      printf("%d is an ancestor of %d.\n", b, a);
      continue;
    }
    if (find(vb.begin(), vb.end(), a) != vb.end()) {
      printf("%d is an ancestor of %d.\n", a, b);
      continue;
    }
    for (int i = 0; i < va.size(); i++) {
      for (int j = 0; j < vb.size(); j++) {
        if (va[i] == vb[j]) {
          printf("LCA of %d and %d is %d.\n", a, b, va[i]);
          goto end;
        }
      }
    }
  end:
    continue;
  }
}
