/*
 * @lc app=leetcode.cn id=865 lang=cpp
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
  int maxdep = 0;
  TreeNode* ans;
  TreeNode* subtreeWithAllDeepest(TreeNode* root) {
    dfs(root, 0);
    dfs2(root, 0);
    return ans;
  }
  void dfs(TreeNode* root, int dep) {
    maxdep = max(maxdep, dep);
    if (root == nullptr)
      return;
    dfs(root->left, dep + 1);
    dfs(root->right, dep + 1);
  }
  int dfs2(TreeNode* root, int dep) {
    if (root == nullptr)
      return dep;
    int left = dfs2(root->left, dep + 1);
    int right = dfs2(root->right, dep + 1);
    if (left == maxdep && right == maxdep)
      ans = root;
    return max(left, right);
  }
};
// @lc code=end
