
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

  public int sumNumbers(TreeNode root) {
    dfs(root, root.val);
    return ans;
  }

  void dfs(TreeNode t, int val) {
    if (t.left == null && t.right == null)
      ans += val;
    if (t.left != null)
      dfs(t.left, val * 10 + t.left.val);
    if (t.right != null)
      dfs(t.right, val * 10 + t.right.val);
  }
}