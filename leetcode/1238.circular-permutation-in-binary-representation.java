/*
 * @lc app=leetcode.cn id=1238 lang=java
 *
 * [1238] Circular Permutation in Binary Representation
 */

// @lc code=start
class Solution {
  public List<Integer> circularPermutation(int n, int start) {
    int total = 1 << n;
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < total; i++) {
      res.add(start ^ i ^ (i >> 1));
    }
    return res;
  }
}
// @lc code=end
