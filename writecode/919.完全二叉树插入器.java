import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=919 lang=java
 *
 * [919] 完全二叉树插入器
 */

// @lc code=start

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

class CBTInserter {
  TreeNode rNode;
  List<TreeNode> q;

  public CBTInserter(TreeNode root) {
    rNode = root;
    q = new ArrayList<>();
    q.add(rNode);
  }

  public int insert(int val) {
    while (true) {
      TreeNode father = q.get(0);
      if (father.left == null) {
        TreeNode nNode = new TreeNode(val);
        father.left = nNode;
        return father.val;
      } else if (father.right == null) {
        TreeNode nNode = new TreeNode(val);
        father.right = nNode;
        return father.val;
      } else {
        q.remove(0);
        q.add(father.left);
        q.add(father.right);
      }
    }
  }

  public TreeNode get_root() {
    return rNode;
  }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end
