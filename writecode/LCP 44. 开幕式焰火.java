import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  HashSet<Integer> set = new HashSet<>();

  public int numColor(TreeNode root) {
    dfs(root);
    return set.size();
  }

  void dfs(TreeNode root) {
    if (root == null)
      return;
    set.add(root.val);
    dfs(root.left);
    dfs(root.right);
  }
}