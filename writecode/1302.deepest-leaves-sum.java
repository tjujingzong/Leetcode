
/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
  int maxlen = 0;
  int sum = 0;

  public int deepestLeavesSum(TreeNode root) {
    dfs(root, 1);
    return sum;
  }

  public void dfs(TreeNode root, int depth) {
    if (root == null)
      return;
    if (depth > maxlen) {
      maxlen = depth;
      sum = 0;
    }
    if (depth == maxlen)
      sum += root.val;
    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
  }
}
// @lc code=end
