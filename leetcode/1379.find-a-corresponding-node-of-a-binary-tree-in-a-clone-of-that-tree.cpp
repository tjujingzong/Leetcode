/*
 * @lc app=leetcode.cn id=1379 lang=cpp
 *
 * [1379] Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
 public:
  TreeNode* getTargetCopy(TreeNode* original,
                          TreeNode* cloned,
                          TreeNode* target) {
    TreeNode* ans = dfs(cloned, target);
    return ans;
  }
  TreeNode* dfs(TreeNode* root, TreeNode* target) {
    if (root == NULL)
      return NULL;
    if (root->val == target->val)
      return root;
    TreeNode* left = dfs(root->left, target);
    TreeNode* right = dfs(root->right, target);
    if (left)
      return left;
    if (right)
      return right;
    return NULL;
  }
};
// @lc code=end
