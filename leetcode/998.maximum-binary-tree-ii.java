import java.util.ArrayList;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=998 lang=java
 *
 * [998] Maximum Binary Tree II
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
class Solution {//写的不对
  TreeSet<Integer> set = new TreeSet<>();

  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    dfs(root);
    set.add(val);
    Integer biggerval = set.higher(val);
    if (biggerval == null) {
      TreeNode newroot = new TreeNode(val);
      newroot.left = root;
      return newroot;
    }
    dfss(root, biggerval, val);
    return root;
  }

  public void dfs(TreeNode root) {
    if (root == null)
      return;
    set.add(root.val);
    dfs(root.left);
    dfs(root.right);
  }

  public void dfss(TreeNode root, int biggerval, int v) {
    if (root == null)
      return;
    if (root.val == biggerval) {
      TreeNode newnode = new TreeNode(v);
      if (root.right != null)
        newnode.left = root.right;
      root.right = newnode;
      return;
    }
    dfss(root.left, biggerval, v);
    dfss(root.right, biggerval, v);

  }
}
// @lc code=end
