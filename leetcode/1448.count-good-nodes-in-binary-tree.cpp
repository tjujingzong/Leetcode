/*
 * @lc app=leetcode.cn id=1448 lang=cpp
 *
 * [1448] Count Good Nodes in Binary Tree
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
  int ans = 0;
  int goodNodes(TreeNode* root) {
    dfs(root, INT_MIN);
    return ans;
  }
  void dfs(TreeNode* root, int max) {
    if (root == nullptr)
      return;
    if (root->val >= max) {
      ans++;
      max = root->val;
    }
    dfs(root->left, max);
    dfs(root->right, max);
  }
};
// @lc code=end
