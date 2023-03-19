/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(nums, 0, path, ans);
    return ans;
  }

  void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> ans) {
    ans.add(path);
    for (; i < nums.length; i++) {
      List<Integer> newpath = new ArrayList<>(path);
      newpath.add(nums[i]);
      dfs(nums, i + 1, newpath, ans);
    }
  }
}
// @lc code=end
