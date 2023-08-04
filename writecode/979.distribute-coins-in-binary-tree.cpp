/*
 * @lc app=leetcode.cn id=979 lang=cpp
 *
 * [979] Distribute Coins in Binary Tree
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
  int ans;
  int dfs(TreeNode* root) {
    if (root == nullptr)
      return 0;
    int left = dfs(root->left);
    int right = dfs(root->right);
    int d = left + right + root->val - 1;
    ans += abs(d);
    return d;
  }
  int distributeCoins(TreeNode* root) {
    ans = 0;
    dfs(root);
    return ans;
    
  }
};
// @lc code=end
