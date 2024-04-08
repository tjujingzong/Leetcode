/*
 * @lc app=leetcode.cn id=894 lang=cpp
 *
 * [894] All Possible Full Binary Trees
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
  vector<TreeNode*> allPossibleFBT(int n) {
    vector<TreeNode*> res;
    if (n % 2 == 0)
      return res;
    if (n == 1) {
      res.push_back(new TreeNode(0));
      return res;
    }
    for (int i = 1; i < n; i += 2) {
      vector<TreeNode*> left = allPossibleFBT(i);
      vector<TreeNode*> right = allPossibleFBT(n - 1 - i);
      cout << left.size() << " " << right.size() << endl;
      for (auto l : left) {
        for (auto r : right) {
          TreeNode* root = new TreeNode(0);
          root->left = l;
          root->right = r;
          res.push_back(root);
        }
      }
    }
    return res;
  }
};
// @lc code=end
