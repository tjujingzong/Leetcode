
/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
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
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1)
      return new TreeNode(val, root, null);
    root.left = addOneRow2(root.left, val, depth - 1, 0);
    root.right = addOneRow2(root.right, val, depth - 1, 1);
    return root;
  }

  public TreeNode addOneRow2(TreeNode root, int val, int depth, int flag) {
    if (depth == 1) {
      if (flag == 0) {
        return new TreeNode(val, root, null);
      }
      return new TreeNode(val, null, root);
    }
    if (root == null)
      return null;
    root.left = addOneRow2(root.left, val, depth - 1, 0);
    root.right = addOneRow2(root.right, val, depth - 1, 1);
    return root;
  }
}
// @lc code=end
