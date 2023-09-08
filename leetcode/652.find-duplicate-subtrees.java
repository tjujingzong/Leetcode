import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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

class Solution {
  List<TreeNode> ans = new ArrayList<>();
  HashMap<String, Integer> map = new HashMap<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    dfs(root);
    return ans;
  }

  String dfs(TreeNode root) {
    if (root == null)
      return "";
    StringBuilder sb = new StringBuilder();
    sb.append(root.val + "_");
    sb.append(dfs(root.left) + '_');
    sb.append(dfs(root.right) + '_');
    String key = sb.toString();
    map.put(key, map.getOrDefault(key, 0) + 1);
    if (map.get(key) == 2)
      ans.add(root);
    return key;
  }
}
// @lc code=end
