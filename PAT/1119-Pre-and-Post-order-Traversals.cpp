#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isUnique = true;

TreeNode* buildTree(vector<int>& preorder,
                    vector<int>& postorder,
                    int prel,
                    int prer,
                    int postl,
                    int postr) {
  if (prel > prer || postl > postr) {
    return NULL;
  }

  int root_val = preorder[prel];
  TreeNode* root = new TreeNode(root_val);

  if (prel == prer) {
    return root;
  }

  int left_root_val = preorder[prel + 1];
  int left_root_idx = postl;
  while (postorder[left_root_idx] != left_root_val) {
    left_root_idx++;
  }
  int left_size = left_root_idx - postl + 1;

  root->left = buildTree(preorder, postorder, prel + 1, prel + left_size, postl,
                         left_root_idx);
  root->right = buildTree(preorder, postorder, prel + left_size + 1, prer,
                          left_root_idx + 1, postr - 1);

  if ((root->left && !root->right) || (!root->left && root->right)) {
    isUnique = false;
  }

  return root;
}

void inorderTraversal(TreeNode* root, vector<int>& result) {
  if (!root) {
    return;
  }

  inorderTraversal(root->left, result);
  result.push_back(root->val);
  inorderTraversal(root->right, result);
}

int main() {
  int n;
  cin >> n;
  vector<int> preorder(n);
  vector<int> postorder(n);

  for (int i = 0; i < n; i++) {
    cin >> preorder[i];
  }

  for (int i = 0; i < n; i++) {
    cin >> postorder[i];
  }

  TreeNode* root = buildTree(preorder, postorder, 0, n - 1, 0, n - 1);

  vector<int> inorder;
  inorderTraversal(root, inorder);

  if (isUnique) {
    cout << "Yes" << endl;
  } else {
    cout << "No" << endl;
  }

  for (int i = 0; i < inorder.size(); i++) {
    cout << inorder[i];
    if (i < inorder.size() - 1) {
      cout << " ";
    }
  }
  cout << endl;

  return 0;
}
