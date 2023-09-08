#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
int inSq[maxn], preSq[maxn];
int n;

map<int, int> eximp;

struct Node {
  int v;
  Node *lchild, *rchild, *pa;
};

map<Node*, int> vmp;
map<int, Node*> nmp;

Node* create(int inL, int inR, int preL, int preR) {
  if (preL > preR)
    return NULL;

  Node* root = new Node;
  root->v = preSq[preL];
  vmp[root] = root->v;
  nmp[root->v] = root;

  int k;
  for (k = inL; k <= inR; k++) {
    if (inSq[k] == root->v)
      break;
  }

  int leftnum = k - inL;

  root->lchild = create(inL, k - 1, preL + 1, preL + leftnum);
  if (root->lchild)
    root->lchild->pa = root;
  root->rchild = create(k + 1, inR, preL + leftnum + 1, preR);
  if (root->rchild)
    root->rchild->pa = root;
  return root;
}

int getLinkLen(Node* childNode) {
  int ll = 1;
  while (childNode->pa) {
    childNode = childNode->pa;
    ll++;
  }
  return ll;
}

Node* getLCA(Node* p, Node* q) {
  int pLen = getLinkLen(p);
  int qLen = getLinkLen(q);
  while (pLen < qLen) {
    q = q->pa;
    qLen--;
  }
  while (qLen < pLen) {
    p = p->pa;
    pLen--;
  }
  while (p != q) {
    p = p->pa;
    q = q->pa;
  }

  return p;
}

int main() {
  int pNum;
  cin >> pNum >> n;
  for (int i = 0; i < n; i++) {
    cin >> inSq[i];
    eximp[inSq[i]] = 1;
  }
  for (int i = 0; i < n; i++) {
    cin >> preSq[i];
  }

  Node* root = create(0, n - 1, 0, n - 1);

  while (pNum--) {
    int v1, v2;
    cin >> v1 >> v2;
    if (eximp[v1] == 0 || eximp[v2] == 0) {
      if (eximp[v1] == 1)
        printf("ERROR: %d is not found.\n", v2);
      else if (eximp[v2] == 1)
        printf("ERROR: %d is not found.\n", v1);
      else
        printf("ERROR: %d and %d are not found.\n", v1, v2);
      continue;
    }

    Node* p = nmp[v1];
    Node* q = nmp[v2];
    int LCA = vmp[getLCA(p, q)];

    if (LCA == v1 || LCA == v2)
      printf("%d is an ancestor of %d.\n", LCA == v1 ? v1 : v2,
             LCA == v1 ? v2 : v1);
    else
      printf("LCA of %d and %d is %d.\n", v1, v2, LCA);
  }

  return 0;
}
