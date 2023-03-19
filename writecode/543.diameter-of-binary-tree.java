/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  int ans = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return ans;
  }

  public int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    ans = Math.max(ans, left + right);
    return Math.max(left, right) + 1;
  }
}
// @lc code=end
