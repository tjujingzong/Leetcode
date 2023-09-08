import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    dfs(root, 0);
    return ans;
  }

  void dfs(TreeNode root, int i) {
    if (root == null)
      return;
    if (ans.size() == i) {
      ArrayList<Integer> orderi = new ArrayList<Integer>();
      orderi.add(root.val);
      ans.add(orderi);
    } else {
      List<Integer> orderi = ans.get(i);
      orderi.add(root.val);
    }
    dfs(root.left, i + 1);
    dfs(root.right, i + 1);
    return;
  }
}
// @lc code=end
