import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] Print Binary Tree
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
  List<List<String>> ans = new ArrayList<>();
  int depth;
  int breadth;

  public List<List<String>> printTree(TreeNode root) {
    dfs(root, 1);
    breadth = (int) Math.pow(2, depth) - 1;
    for (int i = 0; i < depth; i++) {
      ArrayList<String> children = new ArrayList<String>();
      for (int j = 0; j < Math.pow(2, depth) - 1; j++) {
        children.add("");
      }
      ans.add(children);
    }
    dfs2(root, 0, breadth / 2);
    return ans;
  }

  public void dfs(TreeNode root, int i) {
    if (root == null)
      return;
    depth = Math.max(depth, i);
    dfs(root.right, i + 1);
    dfs(root.left, i + 1);
  }

  public void dfs2(TreeNode root, int index, int pos) {
    if (root == null)
      return;
    List<String> children = ans.get(index);
    children.set(pos, String.valueOf(root.val));
    dfs2(root.left, index + 1, pos - (int) Math.pow(2, depth - 2 - index));
    dfs2(root.right, index + 1, pos + (int) Math.pow(2, depth - 2 - index));
  }
}
// @lc code=end
