/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
  int ans = -1001;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return ans;
  }

  public int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int leftval = dfs(root.left);
    int rightval = dfs(root.right);
    ans = Math.max(ans, root.val + leftval);
    ans = Math.max(ans, root.val + rightval);
    ans = Math.max(ans, root.val + leftval + rightval);
    ans = Math.max(ans, root.val);
    return Math.max(Math.max(leftval, rightval) + root.val, root.val);
  }
}
// @lc code=end
