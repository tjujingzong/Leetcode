class Solution {
  public int[] cycleLengthQueries(int n, int[][] queries) {
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];
      // 在完全二叉树上计算a，b到公共祖先的距离
      int ans1 = 0;
      int ans2 = 0;
      while (a != b) {
        if (a > b) {
          a /= 2;
          ans1++;
        } else {
          b /= 2;
          ans2++;
        }
      }
      ans[i] = ans1 + ans2 + 1;
    }
    return ans;
  }
}