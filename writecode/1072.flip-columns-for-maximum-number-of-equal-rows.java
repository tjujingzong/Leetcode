/*
 * @lc app=leetcode.cn id=1072 lang=java
 *
 * [1072] Flip Columns For Maximum Number of Equal Rows
 */

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
      HashMap<String, Integer> map = new HashMap<>(); 
      int res = 0;
      for (int[] row : matrix) {
        StringBuilder sb = new StringBuilder();
        int first = row[0];
        for (int i = 0; i < row.length; i++) {
          if (row[i] == first) {
            sb.append("1");
          } else {
            sb.append("0");
          }
        }
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        res = Math.max(res, map.get(key));
      }
      return res;
    }
}
// @lc code=end

