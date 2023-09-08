/*
 * @lc app=leetcode.cn id=2331 lang=java
 *
 * [2331] Evaluate Boolean Binary Tree
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
  public boolean evaluateTree(TreeNode root) {
    if (root == null)
      return false;
    if (root.val == 0)
      return false;
    if (root.val == 1)
      return true;
    if (root.val == 2)
      return evaluateTree(root.left) || evaluateTree(root.right);
    if (root.val == 3)
      return evaluateTree(root.left) && evaluateTree(root.right);
    return false;
  }

}
// @lc code=end
