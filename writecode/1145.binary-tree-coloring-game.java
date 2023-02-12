/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
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
  int leftchild = 0;
  int rightchild = 0;
  int parent = 0;

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    dfs(root, x);
    parent = n - leftchild - rightchild - 1;
    return Math.max(Math.max(leftchild, rightchild), parent) > n / 2;
  }

  public int dfs(TreeNode root, int x) {
    if (root == null)
      return 0;
    int left = dfs(root.left, x);
    int right = dfs(root.right, x);
    if (root.val == x) {
      leftchild = left;
      rightchild = right;
    }
    return left + right + 1;
  }

}
// @lc code=end
