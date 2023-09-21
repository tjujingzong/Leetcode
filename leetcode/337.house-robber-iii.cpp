/*
 * @lc app=leetcode.cn id=337 lang=cpp
 *
 * [337] House Robber III
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
 *
 */
class Solution {
 public:
  int rob(TreeNode* root) {
    vector<int> ans = dfs(root);
    return max(ans[0], ans[1]);
  }
  vector<int> dfs(TreeNode*& root) {
    if (root == nullptr)
      return {0, 0};
    vector<int> res;
    vector<int> l = dfs(root->left);
    vector<int> r = dfs(root->right);
    res.push_back(root->val + l[1] + r[1]);
    res.push_back(max(l[0], l[1]) + max(r[0], r[1]));
    return res;
  }
};
// @lc code=end
