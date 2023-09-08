#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int n;
vector<int> arr;
struct Node {
  Node(int data) : data(data), lchild(nullptr), rchild(nullptr) {}
  int data;
  Node *lchild, *rchild;
};
Node* build(int start, int end) {
  if (start > end)
    return nullptr;
  int root_ind = start;
  for (int i = start; i <= end; i++) {
    if (arr[root_ind] > arr[i])
      root_ind = i;
  }
  Node* root = new Node(arr[root_ind]);
  root->lchild = build(start, root_ind - 1);
  root->rchild = build(root_ind + 1, end);
  return root;
}
void levelorder(Node* root) {
  queue<Node*> q;
  q.push(root);
  int start = 0;
  while (q.size()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
      Node* t = q.front();
      q.pop();
      start++&& cout << " ";
      cout << t->data;
      if (t->lchild)
        q.push(t->lchild);
      if (t->rchild)
        q.push(t->rchild);
    }
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    arr.push_back(num);
  }
  Node* root = build(0, n - 1);
  levelorder(root);
  return 0;
}
