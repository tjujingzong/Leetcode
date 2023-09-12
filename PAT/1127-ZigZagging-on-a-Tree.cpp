#include <bits/stdc++.h>
using namespace std;
struct node {
  int val;
  node *l, *r;
  int h;
};
vector<node*> v;
node* build(vector<int>& in,
            vector<int>& post,
            int inl,
            int inr,
            int pl,
            int pr) {
  if (inl > inr)
    return nullptr;
  node* root = new node;
  root->val = post[pr];
  int k = 0;
  for (int i = inl; i <= inr; i++) {
    if (in[i] == root->val) {
      k = i;
      break;
    }
  }
  int num_l = k - inl;
  root->l = build(in, post, inl, k - 1, pl, pl + num_l - 1);
  root->r = build(in, post, k + 1, inr, pl + num_l, pr - 1);
  return root;
}

void bfs(node* root) {
  queue<node*> q;
  q.push(root);
  root->h = 0;
  while (!q.empty()) {
    node* t = q.front();
    q.pop();
    v.push_back(t);
    if (t->l != nullptr) {
      q.push(t->l);
      t->l->h = t->h + 1;
    }
    if (t->r != nullptr) {
      q.push(t->r);
      t->r->h = t->h + 1;
    }
  }
}

int main() {
  int n;
  cin >> n;
  vector<int> in;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    in.push_back(t);
  }
  vector<int> post;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    post.push_back(t);
  }
  node* root = build(in, post, 0, n - 1, 0, n - 1);
  cout << root->val;
  bfs(root);
  for (int i = 1; i < v.size(); i++) {
    if (v[i]->h % 2 != 0) {
      cout << " " << v[i]->val;
    } else {
      int j = i;
      while (j < v.size() && v[j]->h % 2 == 0) {
        j++;
      }
      for (int k = j - 1; k >= i; k--) {
        cout << " " << v[k]->val;
      }
      i = j - 1;
    }
  }
}