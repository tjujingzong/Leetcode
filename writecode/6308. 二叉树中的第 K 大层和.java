import java.util.ArrayList;
import java.util.Arrays;

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
  long[] arr;

  public long kthLargestLevelSum(TreeNode root, int k) {
    arr = new long[100005];
    dfs(root, 1);
    Arrays.sort(arr);
    return arr[100004 - k + 1] == 0 ? -1 : arr[100004 - k + 1];
  }

  void dfs(TreeNode root, int level) {
    if (root == null)
      return;
    arr[level] += root.val;
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }
}