class Solution {
  public int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] ans = new int[n][n];
    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int row1 = query[0];
      int col1 = query[1];
      int row2 = query[2];
      int col2 = query[3];
      for (int j = row1; j <= row2; j++) {
        for (int k = col1; k <= col2; k++) {
          ans[j][k]++;
        }
      }
    }
    return ans;
  }
}