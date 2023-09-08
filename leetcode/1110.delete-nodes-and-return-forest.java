/*
 * @lc app=leetcode.cn id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;

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
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> toDeleteSet = new HashSet<Integer>();
    for (int val : to_delete) {
      toDeleteSet.add(val);
    }
    List<TreeNode> roots = new ArrayList<TreeNode>();
    dfs(root, true, toDeleteSet, roots);
    return roots;
  }

  public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> roots) {
    if (node == null) {
      return null;
    }
    boolean deleted = toDeleteSet.contains(node.val);
    node.left = dfs(node.left, deleted, toDeleteSet, roots);
    node.right = dfs(node.right, deleted, toDeleteSet, roots);
    if (deleted) {
      return null;
    } else {
      if (isRoot) {
        roots.add(node);
      }
      return node;
    }
  }
}
// @lc code=end
