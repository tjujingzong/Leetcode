/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      dfs(root,min,max);
      return ans;
    }
    public void dfs(TreeNode root,int min,int max){
      if(root==null){
        return;
      }
      min=Math.min(min,root.val);
      max=Math.max(max,root.val);
      ans=Math.max(max-min,ans);
      dfs(root.left,min,max);
      dfs(root.right,min,max);
  
    }
}
// @lc code=end

