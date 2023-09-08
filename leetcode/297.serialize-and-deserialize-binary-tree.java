/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// public class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode(int x) {
//     val = x;
//   }
// }

public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    // 前序遍历
    if (root == null)
      return "null";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] nodes = data.split(",");
    if (nodes[0].equals("null") || nodes[0].equals("")) {
      if (nodes.length > 1)
        data = data.substring(data.indexOf(nodes[1]));
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    if (nodes.length > 1)
      data = data.substring(data.indexOf(nodes[1]));
    root.left = deserialize(data);
    root.right = deserialize(data);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
