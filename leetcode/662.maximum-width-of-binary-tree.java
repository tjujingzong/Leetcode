/*
* @lc app=leetcode.cn id=662 lang=java
*
* [662] Maximum Width of Binary Tree
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
  long[] left = new long[3005];
  long[] right = new long[3005];
  long ans = 1;

  public int widthOfBinaryTree(TreeNode root) {
    dfs(root, 1, 1);
    for (int i = 0; i < 3005; i++)
      ans = Math.max(ans, right[i] - left[i] + 1);
    return (int) ans;
  }

  void dfs(TreeNode root, int depth, long index) {
    if (root == null)
      return;
    left[depth] = left[depth] == 0 ? index : Math.min(left[depth], index);
    right[depth] = right[depth] == 0 ? index : Math.max(right[depth], index);
    dfs(root.left, depth + 1, 2 * index);
    dfs(root.right, depth + 1, 2 * index + 1);
  };
}
// @lc code=end
