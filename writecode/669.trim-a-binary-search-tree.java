/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] Trim a Binary Search Tree
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
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null)
      return null;
    TreeNode leftnode = trimBST(root.left, low, high);
    TreeNode rightnode = trimBST(root.right, low, high);
    if (root.val <= high && root.val >= low) {
      root.left = leftnode;
      root.right = rightnode;
      return root;
    } else if (leftnode != null) {
      root = leftnode;
      root.right = rightnode;
      return root;
    } else if (rightnode != null) {
      root = rightnode;
      root.right = leftnode;
      return root;
    }
    return null;
  }
}
// @lc code=end
