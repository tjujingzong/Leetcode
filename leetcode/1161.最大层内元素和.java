import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
  HashMap<Integer, Integer> map = new HashMap<>();

  public int maxLevelSum(TreeNode root) {
    dfs(root, 1);
    int ans = 0;
    int max = -1000000;
    for (int i : map.keySet()) {
      if (map.get(i) > max) {
        max = map.get(i);
        ans = i;
      }
    }
    return ans;
  }

  private void dfs(TreeNode root, int i) {
    if (root == null)
      return;
    map.put(i, map.getOrDefault(i, 0) + root.val);
    dfs(root.left, i + 1);
    dfs(root.right, i + 1);
  }
}
// @lc code=end
