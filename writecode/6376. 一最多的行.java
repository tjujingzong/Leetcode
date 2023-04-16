class Solution {
  public int[] rowAndMaximumOnes(int[][] mat) {
    int[] ans = new int[2];
    int max = 0;
    int row = 0;
    for (int i = 0; i < mat.length; i++) {
      int count = 0;
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1)
          count++;
      }
      if (count > max) {
        max = count;
        row = i;
      }
    }
    ans[0] = row;
    ans[1] = max;
    return ans;
  }
}