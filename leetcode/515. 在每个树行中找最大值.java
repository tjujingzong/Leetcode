import java.util.ArrayList;
import java.util.List;

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
  class TreeNode2 extends TreeNode {
    int height;

    TreeNode2(TreeNode t, int h) {
      this.val = t.val;
      this.left = t.left;
      this.right = t.right;
      this.height = h;
    }
  }

  List<Integer> ans = new ArrayList<>();
  ArrayList<TreeNode2> temp = new ArrayList<>();

  public List<Integer> largestValues(TreeNode root) {
    if (root == null)
      return ans;
    TreeNode2 root2 = new TreeNode2(root, 1);
    temp.add(root2);
    int maxnum = Integer.MIN_VALUE;
    int temph = 1;
    while (!temp.isEmpty()) {
      TreeNode2 head = temp.get(0);
      temp.remove(0);
      if (head == null)
        continue;
      if (temph < head.height) {
        temph = head.height;
        ans.add(maxnum);
        maxnum = Integer.MIN_VALUE;
      }
      if (head.val > maxnum)
        maxnum = head.val;
      if (head.left != null)
        temp.add(new TreeNode2(head.left, head.height + 1));
      if (head.right != null)
        temp.add(new TreeNode2(head.right, head.height + 1));
    }
    ans.add(maxnum);
    return ans;
  }
}