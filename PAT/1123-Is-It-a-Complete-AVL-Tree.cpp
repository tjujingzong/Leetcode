#include <cmath>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// AVL树的结点定义
struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  int height;
  TreeNode(int v) : val(v), left(NULL), right(NULL), height(1) {}
};

// 获取树的高度
int getHeight(TreeNode* root) {
  if (root == NULL)
    return 0;
  return root->height;
}

// 更新结点的高度
void updateHeight(TreeNode* root) {
  root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
}

// 计算结点的平衡因子
int getBalanceFactor(TreeNode* root) {
  if (root == NULL)
    return 0;
  return getHeight(root->left) - getHeight(root->right);
}

// 右旋操作
TreeNode* rightRotate(TreeNode* root) {
  TreeNode* newRoot = root->left;
  root->left = newRoot->right;
  newRoot->right = root;
  updateHeight(root);
  updateHeight(newRoot);
  return newRoot;
}

// 左旋操作
TreeNode* leftRotate(TreeNode* root) {
  TreeNode* newRoot = root->right;
  root->right = newRoot->left;
  newRoot->left = root;
  updateHeight(root);
  updateHeight(newRoot);
  return newRoot;
}

// 插入操作
TreeNode* insert(TreeNode* root, int val) {
  if (root == NULL) {
    return new TreeNode(val);
  }

  if (val < root->val) {
    root->left = insert(root->left, val);
  } else {
    root->right = insert(root->right, val);
  }

  // 更新结点的高度
  updateHeight(root);

  // 检查平衡因子
  int balance = getBalanceFactor(root);

  // 平衡维护
  if (balance > 1) {
    if (val < root->left->val) {
      return rightRotate(root);
    }
    if (val > root->left->val) {
      root->left = leftRotate(root->left);
      return rightRotate(root);
    }
  }

  if (balance < -1) {
    if (val > root->right->val) {
      return leftRotate(root);
    }
    if (val < root->right->val) {
      root->right = rightRotate(root->right);
      return leftRotate(root);
    }
  }

  return root;
}

// 层序遍历
vector<int> levelOrder(TreeNode* root) {
  vector<int> result;
  if (root == NULL)
    return result;

  queue<TreeNode*> q;
  q.push(root);

  while (!q.empty()) {
    TreeNode* current = q.front();
    q.pop();
    result.push_back(current->val);

    if (current->left)
      q.push(current->left);
    if (current->right)
      q.push(current->right);
  }

  return result;
}

// 判断是否为完全二叉树
bool isCompleteTree(TreeNode* root) {
  if (root == NULL)
    return true;

  queue<TreeNode*> q;
  q.push(root);

  while (!q.empty()) {
    TreeNode* current = q.front();
    q.pop();

    if (current == NULL) {
      while (!q.empty()) {
        TreeNode* temp = q.front();
        q.pop();
        if (temp != NULL)
          return false;
      }
    } else {
      q.push(current->left);
      q.push(current->right);
    }
  }

  return true;
}

int main() {
  int N;
  cin >> N;
  vector<int> keys(N);
  for (int i = 0; i < N; i++) {
    cin >> keys[i];
  }

  TreeNode* root = NULL;

  for (int i = 0; i < N; i++) {
    root = insert(root, keys[i]);
  }

  vector<int> traversal = levelOrder(root);

  for (int i = 0; i < traversal.size(); i++) {
    cout << traversal[i];
    if (i < traversal.size() - 1) {
      cout << " ";
    }
  }
  cout << endl;

  if (isCompleteTree(root)) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }

  return 0;
}
