import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
  HashMap<Integer, Integer> mapp = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    for (int i = 0; i < n; i++) {
      mapp.put(inorder[i], i);
    }
    return mybuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  public TreeNode mybuildTree(int[] preorder, int[] inorder, int i, int j, int k, int l) {
    if (i > j)
      return null;
    TreeNode root = new TreeNode(preorder[i]);
    int rootpos = mapp.get(preorder[i]);
    int subTreeSize = rootpos - k;
    root.left = mybuildTree(preorder, inorder, i + 1, i + subTreeSize, k, rootpos - 1);
    root.right = mybuildTree(preorder, inorder, i + subTreeSize + 1, j, rootpos + 1, l);
    return root;
  }
}
// @lc code=end
