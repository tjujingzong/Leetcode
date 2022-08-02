
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  int ans = 0;
  int height = 0;

  public int findBottomLeftValue(TreeNode root) {
    searchValue(root, 0);
    return ans;
  }

  public void searchValue(TreeNode root, int h) {
    if (root == null)
      return;
    if (h > height) {
      ans = root.val;
      height = h;
    }
    searchValue(root.left, h + 1);
    searchValue(root.right, h + 1);
  }
}