/*
 * @lc app=leetcode.cn id=617 lang=cpp
 *
 * [617] Merge Two Binary Trees
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
 public:
  TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
    TreeNode* root = NULL;
    dfs(root, root1, root2);
    return root;
  }
  void dfs(TreeNode*& root, TreeNode* root1, TreeNode* root2) {
    if (root1 == NULL && root2 == NULL) {
      return;
    }
    if (root1 == NULL) {
      root = root2;
      return;
    }
    if (root2 == NULL) {
      root = root1;
      return;
    }
    root = new TreeNode(root1->val + root2->val);
    dfs(root->left, root1->left, root2->left);
    dfs(root->right, root1->right, root2->right);
  }
};
// @lc code=end
