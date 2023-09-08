/*
 * @lc app=leetcode.cn id=1572 lang=cpp
 *
 * [1572] Matrix Diagonal Sum
 */

// @lc code=start
class Solution {
 public:
  int diagonalSum(vector<vector<int>>& mat) {
    int n = mat.size();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += mat[i][i];
      if (n - 1 - i != i)
        sum += mat[i][n - 1 - i];
    }
    return sum;
  }
};
// @lc code=end
