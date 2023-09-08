
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] Maximum Binary Tree
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
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0)
      return null;
    int p = 0;
    int max = -1;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] > max) {
        p = i;
        max = nums[i];
      }
    }
    TreeNode root = new TreeNode(max);
    int[] left = new int[p];
    int[] right = new int[Math.max(0, n - p - 1)];
    for (int i = 0; i < p; i++)
      left[i] = nums[i];
    for (int i = p + 1; i < n; i++)
      right[i - p - 1] = nums[i];
    root.left = constructMaximumBinaryTree(left);
    root.right = constructMaximumBinaryTree(right);
    return root;
  }
}
// @lc code=end
