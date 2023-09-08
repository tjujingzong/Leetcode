
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
  public TreeNode expandBinaryTree(TreeNode root) {
    dfs(root);
    return root;
  }

  public void dfs(TreeNode root) {
    if (root == null)
      return;
    if (root.left != null) {
      TreeNode left = root.left;
      root.left = new TreeNode(-1, left, null);
      dfs(left);
    }
    if (root.right != null) {
      TreeNode r = root.right;
      root.right = new TreeNode(-1, null, r);
      dfs(r);
    }
  }
}