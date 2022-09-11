/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] Longest Univalue Path
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
  int ans;

  public int longestUnivaluePath(TreeNode root) {
    if (root == null)
      return 0;
    dfs(root);
    return ans;
  }

  int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    int left1 = 0, right1 = 0;
    if (root.left != null && root.left.val == root.val)
      left1 = left + 1;
    if (root.right != null && root.right.val == root.val)
      right1 = right + 1;
    ans = Math.max(ans, right1 + left1);
    return Math.max(left1, right1);
  }
}
// @lc code=end
