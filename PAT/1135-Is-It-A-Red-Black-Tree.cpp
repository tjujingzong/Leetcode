#include <bits/stdc++.h>
using namespace std;

bool isrbtree = true;
struct node {
  node *l, *r;
  int val;
  bool isred;
};

node* build(vector<int>& in,
            vector<int>& pre,
            int inl,
            int inr,
            int pl,
            int pr,
            unordered_set<int>& s) {
  if (inl > inr)
    return NULL;
  node* root = new node;  // 必写
  root->val = pre[pl];
  if (s.find(root->val) != s.end())
    root->isred = true;
  else
    root->isred = false;
  int k = 0;
  for (int i = inl; i <= inr; i++) {
    if (in[i] == root->val) {
      k = i;
      break;
    }
  }
  int leftnum = k - inl;
  root->l = build(in, pre, inl, k - 1, pl + 1, pl + leftnum, s);
  root->r = build(in, pre, k + 1, inr, pl + leftnum + 1, pr, s);
  return root;
}

void checkred(node*& root) {
  if (root->isred) {
    if (root->l != NULL) {
      if (root->l->isred) {
        isrbtree = false;
        return;
      }
    }
    if (root->r != NULL) {
      if (root->r->isred) {
        isrbtree = false;
        return;
      }
    }
  }
  if (root->l != NULL)
    checkred(root->l);
  if (root->r != NULL)
    checkred(root->r);
}

int getblackpath(node*& root) {
  if (root == NULL)
    return 0;
  int nl = getblackpath(root->l);
  int nr = getblackpath(root->r);
  if (nl != nr) {
    isrbtree = false;
  }
  return nl + (root->isred ? 0 : 1);
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    isrbtree = true;
    int n;
    cin >> n;
    unordered_set<int> s;
    vector<int> pre;
    vector<int> in;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      if (x < 0) {
        x = -x;
        s.insert(x);
      }
      pre.push_back(x);
      in.push_back(x);
    }
    if (s.find(pre[0]) != s.end()) {
      cout << "No" << endl;
      continue;
    }
    sort(in.begin(), in.end());
    node* root = build(in, pre, 0, n - 1, 0, n - 1, s);
    checkred(root);
    // cout << isrbtree << "checkred" << endl;
    if (!isrbtree) {
      cout << "No" << endl;
      continue;
    }
    getblackpath(root);
    // cout << isrbtree << "checkpath" << endl;
    if (!isrbtree) {
      cout << "No" << endl;
      continue;
    }
    cout << "Yes" << endl;
  }
}