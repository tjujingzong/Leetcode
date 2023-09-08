#include <bits/stdc++.h>
using namespace std;
struct node {
  int data;
  int height;
  node *left, *right;
  node* parent;
};
int post[40];
int in[40];
bool isfull = true;
unordered_map<int, node*> mp;
node* buildTree(int post[], int in[], int n) {
  if (n <= 0)
    return NULL;
  int rootData = post[n - 1];
  node* root = new node();
  root->data = rootData;
  int k = 0;
  for (int i = 0; i < n; i++) {
    if (in[i] == rootData) {
      k = i;
      break;
    }
  }
  root->left = buildTree(post, in, k);
  root->right = buildTree(post + k, in + k + 1, n - k - 1);
  return root;
}
void dfs(node* root, int height) {
  if (root == NULL)
    return;
  root->height = height;
  if (root->left != NULL)
    root->left->parent = root;
  if (root->right != NULL)
    root->right->parent = root;

  if (root->left == NULL && root->right != NULL)
    isfull = false;
  if (root->left != NULL && root->right == NULL)
    isfull = false;
  dfs(root->left, height + 1);
  dfs(root->right, height + 1);
  mp[root->data] = root;
}

int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> post[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> in[i];
  }
  node* root = buildTree(post, in, n);
  dfs(root, 0);
  int m;
  cin >> m;
  cin.ignore();
  for (int i = 0; i < m; i++) {
    string s;
    getline(cin, s);
    if (s == "It is a full tree") {
      if (isfull)
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("root") != std::string::npos) {
      int index = s.find(" ");
      int num = stoi(s.substr(0, index));
      if (mp[num] == root)
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("siblings") != std::string::npos) {
      int index = s.find(" ");
      int num1 = stoi(s.substr(0, index));
      int index2 = s.find(" ", index + 1);
      int index3 = s.find(" are");
      int num2 = stoi(s.substr(index2 + 1, index3 - index2));
      if (mp[num1]->parent == mp[num2]->parent)
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("left") != std::string::npos) {
      int index1 = s.find(" ");
      int num1 = stoi(s.substr(0, index1));
      int index2 = s.find("of", index1 + 1);
      int num2 = stoi(s.substr(index2 + 3));
      if (mp[num2]->left == mp[num1])
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("right") != std::string::npos) {
      int index1 = s.find(" ");
      int num1 = stoi(s.substr(0, index1));
      int index2 = s.find("of", index1 + 1);
      int num2 = stoi(s.substr(index2 + 3));
      if (mp[num2]->right == mp[num1])
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("parent") != std::string::npos) {
      int index1 = s.find(" ");
      int num1 = stoi(s.substr(0, index1));
      int index2 = s.find("of", index1 + 1);
      int num2 = stoi(s.substr(index2 + 3));
      if (mp[num2]->parent == mp[num1])
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    } else if (s.find("same") != std::string::npos) {
      int index = s.find(" ");
      int num1 = stoi(s.substr(0, index));
      int index2 = s.find(" ", index + 1);
      int index3 = s.find(" are");
      int num2 = stoi(s.substr(index2 + 1, index3 - index2));
      if (mp[num1]->height == mp[num2]->height)
        cout << "Yes" << endl;
      else
        cout << "No" << endl;
    }
  }
}